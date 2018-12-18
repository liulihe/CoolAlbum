package com.kkkitsch.coolalbum.service;

import java.util.List;

import com.kkkitsch.coolalbum.entity.TFriend;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.util.MyMsg;

public interface TFriendService {

	public MyMsg<TMember> confirmAdd(Integer curMemId, String friendId);

	public List<TFriend> getFriend(Integer getmId);

}
