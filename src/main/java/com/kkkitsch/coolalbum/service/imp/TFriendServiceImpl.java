package com.kkkitsch.coolalbum.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkkitsch.coolalbum.dao.TFriendMapper;
import com.kkkitsch.coolalbum.entity.TFriend;
import com.kkkitsch.coolalbum.entity.TFriendExample;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.entity.TFriendExample.Criteria;
import com.kkkitsch.coolalbum.service.TFriendService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Service
public class TFriendServiceImpl implements TFriendService {

	@Autowired
	TFriendMapper tFriendMapper;

	/**
	 * 添加好友
	 */
	@Override
	public MyMsg<TMember> confirmAdd(Integer curMemId, String curMemAcct, String friendId, String friendAcct) {

		TFriend friend = new TFriend();
		// 封装查询条件
		TFriendExample example = new TFriendExample();
		Criteria criteria = example.createCriteria();
		criteria.andFMemberidEqualTo(curMemId);
		criteria.andFFriendidEqualTo(Integer.parseInt(friendId));
		// 查询
		List<TFriend> validateFriend = tFriendMapper.selectByExample(example);
		// 判断是否已经添加好友
		if (!validateFriend.isEmpty()) {
			// 已经有好友了
			return MyMsg.fail("对方已经是你的好友,不能重复添加", null, null);
		} else if (curMemAcct.equals(friendAcct)) {
			// 不能添加自己为好友
			return MyMsg.fail("不能添加自己为好友", null, null);
		} else {
			try {
				// 我有好友
				friend.setfMemberid(curMemId);
				friend.setfFriendacct(friendAcct);
				friend.setfFriendid(Integer.parseInt(friendId));
				tFriendMapper.insertSelective(friend);

				// 好友有我
				friend.setfId(null);
				friend.setfFriendacct(curMemAcct);
				friend.setfMemberid(Integer.parseInt(friendId));
				friend.setfFriendid(curMemId);
				tFriendMapper.insertSelective(friend);
				return MyMsg.success("添加好友成功", null, null);
			} catch (Exception e) {
				return MyMsg.fail("添加失败，发生未知错误", null, null);
			}
		}
	}

	/**
	 * 查询所有好友
	 */
	@Override
	public MyMsg<List<TFriend>> getFriend(Integer mId) {
		// 封装查询条件
		TFriendExample example = new TFriendExample();
		Criteria criteria = example.createCriteria();
		criteria.andFMemberidEqualTo(mId);
		List<TFriend> friendList = tFriendMapper.selectByExample(example);
		// 没有好友
		if (friendList.isEmpty()) {
			return MyMsg.fail("没有好友，赶紧去添加一些吧", null, null);
		} else {
			return MyMsg.success("查询成功", friendList, null);
		}

	}

	@Override
	public MyMsg<TFriend> blackFriend(Integer curMemId, String friendId) {

		TFriendExample example = new TFriendExample();
		Criteria criteria = example.createCriteria();
		criteria.andFFriendidEqualTo(Integer.parseInt(friendId));
		criteria.andFMemberidEqualTo(curMemId);
		List<TFriend> friendList = tFriendMapper.selectByExample(example);
		if (!friendList.isEmpty() && friendList.size() == 1) {
			TFriend friend = friendList.get(0);

			System.out.println("chaxun =======" + friend);

			String isblack = friend.getfIsblack();
			if ("0".equals(isblack.trim())) {
				friend.setfIsblack("1");
			} else {
				friend.setfIsblack("0");
			}
			int affectNum = tFriendMapper.updateByPrimaryKeySelective(friend);
			System.out.println("操作后：" + friend);
			if (affectNum == 1) {
				return MyMsg.success("拉黑成功", friend, null);
			}
		}
		return MyMsg.fail("发生未知错误", null, null);
	}

}
