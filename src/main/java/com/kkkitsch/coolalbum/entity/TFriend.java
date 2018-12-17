package com.kkkitsch.coolalbum.entity;

public class TFriend {
    private Integer fId;

    private Integer fMemberid;

    private Integer fFriendid;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfMemberid() {
        return fMemberid;
    }

    public void setfMemberid(Integer fMemberid) {
        this.fMemberid = fMemberid;
    }

    public Integer getfFriendid() {
        return fFriendid;
    }

    public void setfFriendid(Integer fFriendid) {
        this.fFriendid = fFriendid;
    }

	@Override
	public String toString() {
		return "TFriend [fId=" + fId + ", fMemberid=" + fMemberid + ", fFriendid=" + fFriendid + "]";
	}
    
}