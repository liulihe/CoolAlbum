package com.kkkitsch.coolalbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.kkkitsch.coolalbum.common.MyConstant.*;

import javax.servlet.http.HttpSession;

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

		System.out.println(member);

		// 如果不为空
		if (null != member) {

			MyMsg<TMember> myMsg = tMemberServiceImpl.memberLogin(member);

			// 有/跳转到 /CoolAlbum/member_home.html，无/跳转到
			// /CoolAlbum/member/member_home.html
			if (myMsg.getCode() == 1) {

				myMsg.getContent().setmPassword("");

				System.out.println("登录成功：" + myMsg.getContent());
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

}
