package com.kkkitsch.coolalbum.controller;

import static com.kkkitsch.coolalbum.common.MyConstant.CUR_MEMBER;

import java.util.ArrayList;
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
	public MyMsg<TMember> confirmAdd(String friendId, HttpSession session) {
		TMember member = (TMember) session.getAttribute(CUR_MEMBER);
		Integer curMemId = member.getmId();
		boolean flag = tFriendServiceImpl.confirmAdd(curMemId, friendId);
		if (flag) {
			return MyMsg.success("添加成功", null, null);
		} else {
			return MyMsg.fail("添加好友失败", null, null);
		}
	}

	/**
	 * 查找好友
	 */
	@RequestMapping("/getfriend")
	@ResponseBody
	public MyMsg<List<TMember>> getFriend(HttpSession session) {
		TMember member = (TMember) session.getAttribute(CUR_MEMBER);
		List<TFriend> friendList = tFriendServiceImpl.getFriend(member.getmId());
		// 没有好友
		if (friendList.isEmpty()) {
			return MyMsg.fail("没有好友，赶紧去添加一些吧", null, null);
		} else {
			List<Integer> friendIdList = new ArrayList<Integer>();
			for (TFriend friend : friendList) {
				// 集合中保存好友id
				friendIdList.add(friend.getfFriendid());
			}
			// 根据好友id查询好友信息
			List<TMember> fIdList = tMemberService.getFriend(friendIdList);
			return MyMsg.success("好友查询成功", fIdList, null);
		}
	}

}