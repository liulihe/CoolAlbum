package com.kkkitsch.coolalbum.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkkitsch.coolalbum.dao.TFriendMapper;
import com.kkkitsch.coolalbum.entity.TFriend;
import com.kkkitsch.coolalbum.entity.TFriendExample;
import com.kkkitsch.coolalbum.entity.TFriendExample.Criteria;
import com.kkkitsch.coolalbum.service.TFriendService;

@Service
public class TFriendServiceImpl implements TFriendService {

	@Autowired
	TFriendMapper tFriendMapper;

	/**
	 * 添加好友
	 * @param curMemId 我的id
	 * @param friendId 好友的id
	 */
	@Override
	public boolean confirmAdd(Integer curMemId, String friendId) {
		TFriend friend = new TFriend();
		try {
			// 我添加好友，同时好友列表中也有我，所以双向添加
			friend.setfMemberid(curMemId);
			friend.setfFriendid(Integer.parseInt(friendId));
			tFriendMapper.insertSelective(friend);
			friend.setfMemberid(Integer.parseInt(friendId));
			friend.setfFriendid(curMemId);
			tFriendMapper.insertSelective(friend);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<TFriend> getFriend(Integer mId) {
		TFriendExample example=new TFriendExample();
		Criteria criteria = example.createCriteria();
		criteria.andFMemberidEqualTo(mId);
		List<TFriend> friendList = tFriendMapper.selectByExample(example);
		return friendList;
	}

}
