package com.kkkitsch.coolalbum.controller;

import static com.kkkitsch.coolalbum.common.MyConstant.CUR_MEMBER;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.kkkitsch.coolalbum.entity.TFriend;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.entity.TPhoto;
import com.kkkitsch.coolalbum.service.TFriendService;
import com.kkkitsch.coolalbum.service.TMemberService;
import com.kkkitsch.coolalbum.service.TPhotoService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Controller
@RequestMapping("/friend")
public class TFriendController {

	@Autowired
	TFriendService tFriendServiceImpl;

	@Autowired
	TMemberService tMemberService;

	@Autowired
	TPhotoService photoServiceImpl;

	/**
	 * 添加好友
	 */
	@RequestMapping("/confirmadd")
	@ResponseBody
	public MyMsg<TMember> confirmAdd(String friendId, String friendAcct, HttpSession session) {
		TMember member = (TMember) session.getAttribute(CUR_MEMBER);
		Integer curMemId = member.getmId();
		String curMemAcct = member.getmAccountname();
		return tFriendServiceImpl.confirmAdd(curMemId, curMemAcct, friendId, friendAcct);
	}

	/**
	 * 查找好友
	 */
	@RequestMapping("/getfriend")
	@ResponseBody
	public MyMsg<List<TFriend>> getFriend(HttpSession session) {
		TMember member = (TMember) session.getAttribute(CUR_MEMBER);
		return tFriendServiceImpl.getFriend(member.getmId());
	}

	/**
	 * 加入黑名单
	 */
	@RequestMapping("/black")
	@ResponseBody
	public MyMsg<TFriend> black(String friendId, HttpSession session) {
		TMember member = (TMember) session.getAttribute(CUR_MEMBER);
		Integer curMemId = member.getmId();
		return tFriendServiceImpl.blackFriend(curMemId, friendId);
	}

	/**
	 * 删除好友
	 */
	@RequestMapping("/deletefriend")
	@ResponseBody
	public MyMsg<TFriend> deleteFriend(String friendId, HttpSession session) {
		TMember member = (TMember) session.getAttribute(CUR_MEMBER);
		Integer curMemId = member.getmId();
		return tFriendServiceImpl.deleteFriend(curMemId, friendId);
	}

	/**
	 * 备注好友
	 */
	@RequestMapping("/namedfriend")
	@ResponseBody
	public MyMsg<TFriend> namedFriend(String name, String friendId, HttpSession session) {
		TMember member = (TMember) session.getAttribute(CUR_MEMBER);
		Integer curMemId = member.getmId();
		return tFriendServiceImpl.namedFriend(curMemId, friendId, name);
	}

	/**
	 * 访问验证
	 */
	@RequestMapping("trytoaccess")
	@ResponseBody
	public MyMsg<List<TPhoto>> accessValidate(String friendId, HttpSession session) {
		TMember member = (TMember) session.getAttribute(CUR_MEMBER);
		Integer curMemId = member.getmId();
		boolean access = tFriendServiceImpl.accessValidate(curMemId, friendId);
		if (!access) {
			// 如果好友列表没有你
			return MyMsg.fail("没有访问权限", null, null);
		} else {
			return MyMsg.success("允许访问", null, null);
		}
	}

	@RequestMapping("access")
	public ModelAndView accessFriend(String friendId) {
		List<TPhoto> photo = photoServiceImpl.getAllPhoto(Integer.parseInt(friendId));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("friendphoto");

		if (photo.isEmpty()) {
			mv.addObject("accessMsg", "对方没有照片");
		} else {
			mv.addObject("accessMsg", JSON.toJSONString(photo));
		}
		return mv;
	}
}