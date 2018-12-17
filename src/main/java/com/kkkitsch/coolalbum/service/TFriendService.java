package com.kkkitsch.coolalbum.service;

import java.util.List;

import com.kkkitsch.coolalbum.entity.TFriend;

public interface TFriendService {

	public boolean confirmAdd(Integer curMemId, String friendId);

	public List<TFriend> getFriend(Integer getmId);

}
