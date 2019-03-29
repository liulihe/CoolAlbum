package com.kkkitsch.coolalbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.kkkitsch.coolalbum.common.MyConstant.*;
import javax.servlet.http.HttpSession;
import com.kkkitsch.coolalbum.common.MD5;
import com.kkkitsch.coolalbum.common.MyAcctAndId;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.service.TMemberService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Controller
@RequestMapping("/member")
public class TMemberController {

	@Autowired
	TMemberService tMemberServiceImpl;

	@RequestMapping("/login")
	public String memberLogin(TMember member, Model model, HttpSession session) {
		// 如果不为空
		if (null != member) {
			MyMsg<TMember> myMsg = tMemberServiceImpl.memberLogin(member);
			// 有/跳转到 /CoolAlbum/member_home.html，无/跳转到
			// /CoolAlbum/member/member_home.html
			if (myMsg.getCode() == 1) {
				myMsg.getContent().setmPassword("");
				session.setAttribute(CUR_MEMBER, myMsg.getContent());
				return "redirect:/member_home.html";
			} else {
				model.addAttribute(LOGIN_ERROR_MSG, myMsg.getMsg());
				model.addAttribute(CUR_MEMBER, myMsg.getContent());
				return "forward:/index.jsp";
			}
		} else {
			model.addAttribute(LOGIN_ERROR_MSG, "登录失败，登录信息不能为空");
			model.addAttribute(CUR_MEMBER, member);
			return "forward:/index.jsp";
		}
	}

	@RequestMapping("/register")
	public String memberRegister(TMember member,
			@RequestParam(value = "mRePassword", defaultValue = "") String mRePassword, Model model,
			HttpSession session) {
		// 如果注册信息 不为空
		if (null != member && !"".equals(mRePassword.trim())) {
			// 注册
			MyMsg<TMember> myMsg = tMemberServiceImpl.memberRegister(member, mRePassword);
			// 如果注册成功
			if (myMsg.getCode() == 1) {
				// 在回显数据前清空密码
				myMsg.getContent().setmPassword("");
				// 填充到session中
				session.setAttribute(CUR_MEMBER, myMsg.getContent());
				return "redirect:/member_home.html";
			} else {
				// 注册失败
				model.addAttribute(REGISTER_ERROR_MSG, myMsg.getMsg());
				model.addAttribute(CUR_MEMBER, member);
				return "forward:/index.jsp";
			}
		} else {
			// 注册信息为空
			model.addAttribute(REGISTER_ERROR_MSG, "注册失败，注册信息不能为空");
			model.addAttribute(CUR_MEMBER, member);
			return "forward:/index.jsp";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 移除session
		session.removeAttribute(CUR_MEMBER);
		MyAcctAndId.invalid();
		return "redirect:/index.jsp";
	}

	@RequestMapping("/myinfo")
	@ResponseBody
	public MyMsg<TMember> myInfo(TMember member, HttpSession session) {
		return tMemberServiceImpl.updateMyInfo(member,session);
	}

	/**
	 * 确认修改密码
	 */
	@RequestMapping("/comfirmUpdatePassword")
	@ResponseBody
	public MyMsg<TMember> comfirmUpdatePassword(HttpSession session, String oldPassword, String newPassword,
			String comfirmPassword) {
		// 后端验证
		if (oldPassword == null) {
			return MyMsg.fail("旧密码不能为空", null, null);
		}
		if (oldPassword.length() < 6) {
			return MyMsg.fail("旧密码长度太短", null, null);
		}
		if (newPassword == null) {
			return MyMsg.fail("新密码不能为空", null, null);
		}
		if (newPassword.length() < 6) {
			return MyMsg.fail("新密码长度太短", null, null);
		}
		// 复杂密码
		if (!newPassword.matches("(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{6,30}")) {
			return MyMsg.fail("新密码过于简单，必须包含字母，数字，特殊字符", null, null);
		}
		if (comfirmPassword == null) {
			return MyMsg.fail("确认密码不能为空", null, null);
		}
		if (comfirmPassword.length() < 6) {
			return MyMsg.fail("确认密码长度太短", null, null);
		}
		if (oldPassword.equals(newPassword)) {
			return MyMsg.fail("旧密码和新密码不能一样", null, null);
		}
		if (!newPassword.equals(comfirmPassword)) {
			return MyMsg.fail("两次新的密码不一致", null, null);
		}

		Integer mId = MyAcctAndId.getMyId(session);
		TMember tMember = tMemberServiceImpl.selectById(mId);
		String accountName = MyAcctAndId.getMyAcct(session);

		if (tMember != null) {
			if (!MD5.md5(accountName, oldPassword).equals(tMember.getmPassword())) {
				return MyMsg.fail("您输入的旧密码不正确", null, null);
			}
		}

		// 更新密码
		TMember member = new TMember();
		member.setmId(mId);
		member.setmPassword(MD5.md5(accountName, newPassword));
		boolean flag = tMemberServiceImpl.updatePassword(member);

		// 如果修改成功
		if (flag) {
			// 移除域对象
			session.removeAttribute(CUR_MEMBER);
			return MyMsg.success("更新密码成功", null, null);
		} else {
			// 修改失败
			return MyMsg.fail("更新密码失败", null, null);
		}
	}

	/**
	 * 发现好友
	 */
	@RequestMapping("/findfriend")
	@ResponseBody
	public MyMsg<TMember> findFriend(String friendAcct) {
		return tMemberServiceImpl.findFriend(friendAcct);
	}

}