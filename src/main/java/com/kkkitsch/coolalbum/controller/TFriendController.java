package com.kkkitsch.coolalbum.controller;

import static com.kkkitsch.coolalbum.common.MyConstant.CUR_MEMBER;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkkitsch.coolalbum.entity.TFriend;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.entity.TPhoto;
import com.kkkitsch.coolalbum.entity.TPhototype;
import com.kkkitsch.coolalbum.service.TFriendService;
import com.kkkitsch.coolalbum.service.TMemberService;
import com.kkkitsch.coolalbum.service.TPhotoService;
import com.kkkitsch.coolalbum.service.TPhototypeService;
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

	@Autowired
	TPhototypeService phototypeServiceImpl;

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
	@ResponseBody
	public MyMsg<Object> accessFriend(@RequestParam(value = "pn", defaultValue = "1") int pn,
			@RequestParam(value = "ps", defaultValue = "10") int ps, String friendId,
			@RequestParam(value = "phototypeid", defaultValue = "0") String ptid) {
		// 在查询之前引入分页插件，设置查询页码，每页大小
		PageHelper.startPage(pn, ps);
		List<TPhoto> photos = null;
		if (ptid.equals("0")) {
			photos = photoServiceImpl.getAllPhoto(Integer.parseInt(friendId));
		} else {
			photos = photoServiceImpl.getSelectPhoto(Integer.parseInt(friendId), ptid);
		}

		// 使用PageInfo包装查询的结果，最终只需将PageInfo交给要显示的页面，
		PageInfo<TPhoto> pageInfo = new PageInfo<TPhoto>(photos, 5);
		MyMsg<Object> myMsg = new MyMsg<Object>();
		Map<String, Object> msgMap = new HashMap<String, Object>();

		msgMap.put("friendId", friendId);
		if (photos.isEmpty()) {
			// 没有图片
			msgMap.put("pageInfoMsg", "nothing");
		} else {
			// 有图片 填充图片信息
			msgMap.put("pageInfoMsg", pageInfo);
		}

		// 获取图片类型
		List<TPhototype> phototype = phototypeServiceImpl.getPhototype(Integer.parseInt(friendId));
		if (phototype.isEmpty()) {
			msgMap.put("phototype", "nothing");
		} else {
			msgMap.put("phototype", phototype);
		}
		myMsg.setExt(msgMap);
		return myMsg;
	}
}