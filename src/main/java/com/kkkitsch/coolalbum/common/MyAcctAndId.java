package com.kkkitsch.coolalbum.common;

import static com.kkkitsch.coolalbum.common.MyConstant.CUR_MEMBER;

import javax.servlet.http.HttpSession;

import com.kkkitsch.coolalbum.entity.TMember;

public class MyAcctAndId {

	private static Integer myId = null;
	private static String myAcct = null;

	public static String getMyAcct(HttpSession session) {
		if (myAcct != null) {
			return myAcct;
		} else {
			TMember member = (TMember) session.getAttribute(CUR_MEMBER);
			myAcct = member.getmAccountname();
			return myAcct;
		}
	}

	public static Integer getMyId(HttpSession session) {
		if (myId != null) {
			return myId;
		} else {
			TMember member = (TMember) session.getAttribute(CUR_MEMBER);
			myId = member.getmId();
			return myId;
		}
	}

	public static void invalid() {
		myId = null;
		myAcct = null;
	}

}
