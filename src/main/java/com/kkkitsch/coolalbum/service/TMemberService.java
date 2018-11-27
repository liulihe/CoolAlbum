package com.kkkitsch.coolalbum.service;

import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.util.MyMsg;

public interface TMemberService {

    public MyMsg<TMember> memberLogin(TMember member);

    public MyMsg<TMember> memberRegister(TMember member,String mRePassword);

	public boolean updateMyInfo(TMember member);

}
