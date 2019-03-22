package com.kkkitsch.coolalbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.kkkitsch.coolalbum.common.MyConstant.*;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kkkitsch.coolalbum.common.MD5;
import com.kkkitsch.coolalbum.common.MyAcctAndId;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.service.TMemberService;
import com.kkkitsch.coolalbum.util.MyMsg;

/**
 * @ClassName TMemberController
 * @Description TODO(会员视图跳转的控制器)
 * @author Administrator
 * @Date 2018年11月21日 下午6:13:21
 * @version 1.0.0
 */
@Controller
@RequestMapping("/member")
public class TMemberController {

	@Autowired
	TMemberService tMemberServiceImpl;

	/**
	 * @Description (会员登录)
	 * @param member
	 *            实体映射
	 * @param model
	 *            模型数据
	 * @return 逻辑视图名称或映射url
	 */
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

	/**
	 * @Description (会员注册)
	 * @param member
	 *            实体映射
	 * @param mRePassword
	 *            重复密码
	 * @param model
	 *            模型数据
	 * @return 逻辑视图名称或映射url
	 */
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

	/**
	 * 注销会员
	 * 
	 * @param session
	 * @return 逻辑视图名
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 移除session
		session.removeAttribute(CUR_MEMBER);
		MyAcctAndId.invalid();
		return "redirect:/index.jsp";
	}

	/**
	 * 更新会员信息
	 * 
	 * @param member
	 * @param session
	 * @return
	 */
	@RequestMapping("/myinfo")
	@ResponseBody
	public MyMsg<TMember> myInfo(TMember member, HttpSession session) {
		member.setmId(((TMember) session.getAttribute(CUR_MEMBER)).getmId());
		boolean flag = false;
		if (member != null) {
			flag = tMemberServiceImpl.updateMyInfo(member);
		}

		if (flag) {
			TMember uMember = (TMember) session.getAttribute(CUR_MEMBER);
			uMember.setmNickname(member.getmNickname());
			uMember.setmSignature(member.getmSignature());
			uMember.setmEmail(member.getmEmail());
			session.setAttribute(CUR_MEMBER, uMember);
			return MyMsg.success("更新成功", uMember, null);
		} else {
			return MyMsg.fail("更新失败", null, null);
		}
	}

	/**
	 * 发送验证码
	 */
	@RequestMapping("/sendvalidate")
	@ResponseBody
	public MyMsg<TMember> sendValidate(HttpSession session) {
		// 假装发送了一个验证码
		session.setAttribute("VALIDATE_CODE", 666666);
		return MyMsg.success("发送验证码成功", null, null);
	}

	/**
	 * 验证码失效
	 */
	@RequestMapping("/removevalidate")
	public void removeValidate(HttpSession session) {
		session.removeAttribute("VALIDATE_CODE");
	}

	/**
	 * 确认修改密码
	 */
	@RequestMapping("/comfirmUpdatePassword")
	@ResponseBody
	public MyMsg<TMember> comfirmUpdatePassword(HttpSession session, String oldPassword, String newPassword,
			String comfirmPassword, String validateCode) {

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
		if (validateCode == null || "".equals(validateCode.trim())) {
			return MyMsg.fail("验证码不能为空", null, null);
		}
		if (!validateCode.matches("[0-9]{6}")) {
			return MyMsg.fail("验证码格式错误，只能为6位纯数字", null, null);
		}
		// 验证码不正确
		if (!(Integer.parseInt(validateCode) == (Integer) session.getAttribute("VALIDATE_CODE"))) {
			return MyMsg.fail("验证码不正确", null, null);
		}

		Integer mId = ((TMember) (session.getAttribute(CUR_MEMBER))).getmId();
		TMember tMember = tMemberServiceImpl.selectById(mId);
		String accountName = ((TMember) (session.getAttribute(CUR_MEMBER))).getmAccountname();

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
			session.removeAttribute("VALIDATE_CODE");
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
		List<TMember> list = tMemberServiceImpl.findFriend(friendAcct);
		if (list == null) {
			return MyMsg.fail("没有此账号", null, null);
		} else {
			return MyMsg.success("查找成功", list.get(0), null);
		}
	}

}