package com.kkkitsch.coolalbum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kkkitsch.coolalbum.common.MyAcctAndId;
import com.kkkitsch.coolalbum.entity.TFriend;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.entity.TPhoto;
import com.kkkitsch.coolalbum.service.TFriendService;
import com.kkkitsch.coolalbum.service.TMemberService;
import com.kkkitsch.coolalbum.service.TPhotoService;
import com.kkkitsch.coolalbum.service.TPhototypeService;
import com.kkkitsch.coolalbum.util.MyMsg;

@RequestMapping("/friend")
@RestController
public class TFriendController {

	@Autowired
	TFriendService tFriendServiceImpl;

	@Autowired
	TMemberService tMemberService;

	@Autowired
	TPhotoService photoServiceImpl;

	@Autowired
	TPhototypeService phototypeServiceImpl;

	/**
	 * 添加好友
	 */
	@RequestMapping("/confirmadd")
	public MyMsg<TMember> confirmAdd(String friendId, String friendAcct, HttpSession session) {
		return tFriendServiceImpl.confirmAdd(MyAcctAndId.getMyId(session), MyAcctAndId.getMyAcct(session), friendId,
				friendAcct);
	}

	/**
	 * 查找好友
	 */
	@RequestMapping("/getfriend")
	public MyMsg<List<TFriend>> getFriend(HttpSession session) {
		return tFriendServiceImpl.getFriend(MyAcctAndId.getMyId(session));
	}

	/**
	 * 加入黑名单
	 */
	@RequestMapping("/black")
	public MyMsg<TFriend> black(String friendId, HttpSession session) {
		return tFriendServiceImpl.blackFriend(MyAcctAndId.getMyId(session), friendId);
	}

	/**
	 * 删除好友
	 */
	@RequestMapping("/deletefriend")
	public MyMsg<TFriend> deleteFriend(String friendId, HttpSession session) {
		return tFriendServiceImpl.deleteFriend(MyAcctAndId.getMyId(session), friendId);
	}

	/**
	 * 备注好友
	 */
	@RequestMapping("/namedfriend")
	public MyMsg<TFriend> namedFriend(String name, String friendId, HttpSession session) {
		return tFriendServiceImpl.namedFriend(MyAcctAndId.getMyId(session), friendId, name);
	}

	/**
	 * 访问验证
	 */
	@RequestMapping("trytoaccess")
	public MyMsg<List<TPhoto>> accessValidate(String friendId, HttpSession session) {
		return tFriendServiceImpl.accessValidate(MyAcctAndId.getMyId(session), friendId);
	}

	@RequestMapping("access")
	public MyMsg<Object> accessFriend(@RequestParam(value = "pn", defaultValue = "1") int pn,
			@RequestParam(value = "ps", defaultValue = "10") int ps, String friendId,
			@RequestParam(value = "phototypeid", defaultValue = "0") String ptid) {
		return tFriendServiceImpl.getPhoto(pn, ps, friendId, ptid);
	}
}