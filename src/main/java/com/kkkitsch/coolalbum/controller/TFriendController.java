package com.kkkitsch.coolalbum.controller;

import static com.kkkitsch.coolalbum.common.MyConstant.CUR_MEMBER;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kkkitsch.coolalbum.entity.TFriend;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.service.TFriendService;
import com.kkkitsch.coolalbum.service.TMemberService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Controller
@RequestMapping("/friend")
public class TFriendController {

	@Autowired
	TFriendService tFriendServiceImpl;

	@Autowired
	TMemberService tMemberService;

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
		return tFriendServiceImpl.blackFriend(curMemId,friendId);
	}
}