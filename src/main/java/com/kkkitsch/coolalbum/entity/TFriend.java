package com.kkkitsch.coolalbum.entity;

public class TFriend {
    private Integer fId;

    private Integer fMemberid;

    private String fFriendacct;

    private Integer fFriendid;

    private String fIsblack;

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

    public String getfFriendacct() {
        return fFriendacct;
    }

    public void setfFriendacct(String fFriendacct) {
        this.fFriendacct = fFriendacct == null ? null : fFriendacct.trim();
    }

    public Integer getfFriendid() {
        return fFriendid;
    }

    public void setfFriendid(Integer fFriendid) {
        this.fFriendid = fFriendid;
    }

    public String getfIsblack() {
        return fIsblack;
    }

    public void setfIsblack(String fIsblack) {
        this.fIsblack = fIsblack == null ? null : fIsblack.trim();
    }

	@Override
	public String toString() {
		return "TFriend [fId=" + fId + ", fMemberid=" + fMemberid + ", fFriendacct=" + fFriendacct + ", fFriendid="
				+ fFriendid + ", fIsblack=" + fIsblack + "]";
	}
    
    
    
}