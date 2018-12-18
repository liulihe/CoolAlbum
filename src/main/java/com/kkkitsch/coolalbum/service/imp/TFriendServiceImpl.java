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
	 * 
	 * @param curMemId
	 *            我的id
	 * @param friendId
	 *            好友的id
	 */
	@Override
	public MyMsg<TMember> confirmAdd(Integer curMemId, String friendId) {
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
			System.out.println("=====================");
			for (TFriend tFriend : validateFriend) {
				System.out.println(tFriend);
			}
			System.out.println("=====================");
			return MyMsg.fail("对方已经是你的好友,不能重复添加", null, null);
		} else {
			try {
				// 我添加好友，同时好友列表中也有我，所以双向添加
				friend.setfMemberid(curMemId);
				friend.setfFriendid(Integer.parseInt(friendId));
				tFriendMapper.insertSelective(friend);
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
	public List<TFriend> getFriend(Integer mId) {
		// 封装查询条件
		TFriendExample example = new TFriendExample();
		Criteria criteria = example.createCriteria();
		criteria.andFMemberidEqualTo(mId);
		return tFriendMapper.selectByExample(example);
	}

}
