package com.kkkitsch.coolalbum.entity;

public class TPhototype {
    private Integer pId;

    private String pTypename;

    private Integer pMemberId;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpTypename() {
        return pTypename;
    }

    public void setpTypename(String pTypename) {
        this.pTypename = pTypename == null ? null : pTypename.trim();
    }

    public Integer getpMemberId() {
        return pMemberId;
    }

    public void setpMemberId(Integer pMemberId) {
        this.pMemberId = pMemberId;
    }

	@Override
	public String toString() {
		return "TPhototype [pId=" + pId + ", pTypename=" + pTypename + ", pMemberId=" + pMemberId + "]";
	}
    
    
    
}