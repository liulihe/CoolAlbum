package com.kkkitsch.coolalbum.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.util.MyMsg;

public interface TMemberService {

    public MyMsg<TMember> memberLogin(TMember member);

    public MyMsg<TMember> memberRegister(TMember member,String mRePassword);

	public MyMsg<TMember> updateMyInfo(TMember member, HttpSession session);

	public boolean updatePassword(TMember member);

	public TMember selectById(Integer mId);

	public MyMsg<TMember> findFriend(String friendAcct);

	public List<TMember> getFriend(List<Integer> friendIdList);

}
