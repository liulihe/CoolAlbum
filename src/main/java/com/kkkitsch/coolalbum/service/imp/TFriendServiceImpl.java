package com.kkkitsch.coolalbum.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkkitsch.coolalbum.dao.TFriendMapper;
import com.kkkitsch.coolalbum.entity.TFriend;
import com.kkkitsch.coolalbum.entity.TFriendExample;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.entity.TPhoto;
import com.kkkitsch.coolalbum.entity.TFriendExample.Criteria;
import com.kkkitsch.coolalbum.service.TFriendService;
import com.kkkitsch.coolalbum.service.TPhotoService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Service
public class TFriendServiceImpl implements TFriendService {

	@Autowired
	TFriendMapper tFriendMapper;
	
	@Autowired
	TPhotoService photoServiceImpl;

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
//				friend.setfId(null);
//				friend.setfFriendacct(curMemAcct);
//				friend.setfMemberid(Integer.parseInt(friendId));
//				friend.setfFriendid(curMemId);
//				tFriendMapper.insertSelective(friend);
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
		if (friendList.isEmpty()) {
			// 没有好友
			return MyMsg.fail("没有好友，赶紧去添加一些吧", null, null);
		} else {
			return MyMsg.success("查询成功", friendList, null);
		}

	}

	/**
	 * 拉黑好友/移除拉黑
	 */
	@Override
	public MyMsg<TFriend> blackFriend(Integer curMemId, String friendId) {
		// 封装查询条件
		TFriendExample example = new TFriendExample();
		Criteria criteria = example.createCriteria();
		criteria.andFFriendidEqualTo(Integer.parseInt(friendId));
		criteria.andFMemberidEqualTo(curMemId);
		// 查询要拉黑/移除的好友
		List<TFriend> friendList = tFriendMapper.selectByExample(example);
		if (!friendList.isEmpty() && friendList.size() == 1) {
			TFriend friend = friendList.get(0);
			String isblack = friend.getfIsblack();
			if ("0".equals(isblack.trim())) {
				// 拉黑
				friend.setfIsblack("1");
			} else {
				// 移除拉黑
				friend.setfIsblack("0");
			}
			int affectNum = tFriendMapper.updateByPrimaryKeySelective(friend);
			if (affectNum == 1) {
				return MyMsg.success("拉黑成功", friend, null);
			}
		}
		return MyMsg.fail("发生未知错误", null, null);
	}

	@Override
	public MyMsg<TFriend> deleteFriend(Integer curMemId, String friendId) {
		try {
			// 我删好友
			TFriendExample example = new TFriendExample();
			Criteria criteria = example.createCriteria();
			criteria.andFFriendidEqualTo(Integer.parseInt(friendId));
			criteria.andFMemberidEqualTo(curMemId);
			tFriendMapper.deleteByExample(example);
			System.out.println("执行1");
			// 好友删我
			TFriendExample example1 = new TFriendExample();
			Criteria criteria1 = example.createCriteria();
			criteria1.andFFriendidEqualTo(curMemId);
			criteria1.andFMemberidEqualTo(Integer.parseInt(friendId));
			tFriendMapper.deleteByExample(example1);
			System.out.println("执行2");
			return MyMsg.success("删除成功", null, null);
		} catch (NumberFormatException e) {
			return MyMsg.fail("删除失败", null, null);
		}
	}

	/**
	 * 给好友设置备注
	 */
	@Override
	public MyMsg<TFriend> namedFriend(Integer curMemId, String friendId, String name) {
		TFriend friend = new TFriend();
		friend.setfNamedfriend(name);
		TFriendExample example = new TFriendExample();
		Criteria criteria = example.createCriteria();
		criteria.andFMemberidEqualTo(curMemId);
		criteria.andFFriendidEqualTo(Integer.parseInt(friendId));
		int affectNum = tFriendMapper.updateByExampleSelective(friend, example);
		if (affectNum == 1) {
			return MyMsg.success("备注成功", null, null);
		} else {
			return MyMsg.fail("备注失败", null, null);
		}
	}

	@Override
	public boolean accessValidate(Integer curMemId, String friendId) {
		TFriendExample example = new TFriendExample();
		Criteria criteria = example.createCriteria();
		criteria.andFFriendidEqualTo(curMemId);
		criteria.andFMemberidEqualTo(Integer.parseInt(friendId));
		List<TFriend> getFriend = tFriendMapper.selectByExample(example);
		if (getFriend.isEmpty()) {
			//如果好友列表没有你
			return false;
		} else if (getFriend.get(0).getfIsblack().equals("1")) {
			//如果好友将你加入黑名单
			return false;
		}else{
			//可以访问
			return true;
		}
	}

}
