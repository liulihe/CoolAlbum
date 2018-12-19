package com.kkkitsch.coolalbum.service;

import java.util.List;

import com.kkkitsch.coolalbum.entity.TFriend;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.util.MyMsg;

public interface TFriendService {

	public MyMsg<TMember> confirmAdd(Integer curMemId, String curMemAcct,String friendId,String friendAcct);

	public MyMsg<List<TFriend>> getFriend(Integer getmId);

	public MyMsg<TFriend> blackFriend(Integer curMemId, String friendId);

	public MyMsg<TFriend> deleteFriend(Integer curMemId, String friendId);

	public MyMsg<TFriend> namedFriend(Integer curMemId, String friendId, String name);

}
