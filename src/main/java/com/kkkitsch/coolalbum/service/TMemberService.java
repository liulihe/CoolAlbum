package com.kkkitsch.coolalbum.service;

import java.util.List;

import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.util.MyMsg;

public interface TMemberService {

    public MyMsg<TMember> memberLogin(TMember member);

    public MyMsg<TMember> memberRegister(TMember member,String mRePassword);

	public boolean updateMyInfo(TMember member);

	public boolean updatePassword(TMember member);

	public TMember selectById(Integer mId);

	public List<TMember> findFriend(String friendAcct);

	public List<TMember> getFriend(List<Integer> friendIdList);

}
