package com.kkkitsch.coolalbum.entity;

import java.util.Date;

public class TPhoto {
    private Integer pId;

    private String pName;

    private Date pCreatetime;

    private Date pModitytime;

    private String pUrl;

    private String pDescription;

    private Integer pLikenum;

    private String pClicklikeMemberid;

    private Integer pTypeId;

    private Integer pMemberId;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Date getpCreatetime() {
        return pCreatetime;
    }

    public void setpCreatetime(Date pCreatetime) {
        this.pCreatetime = pCreatetime;
    }

    public Date getpModitytime() {
        return pModitytime;
    }

    public void setpModitytime(Date pModitytime) {
        this.pModitytime = pModitytime;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl == null ? null : pUrl.trim();
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription == null ? null : pDescription.trim();
    }

    public Integer getpLikenum() {
        return pLikenum;
    }

    public void setpLikenum(Integer pLikenum) {
        this.pLikenum = pLikenum;
    }

    public String getpClicklikeMemberid() {
        return pClicklikeMemberid;
    }

    public void setpClicklikeMemberid(String pClicklikeMemberid) {
        this.pClicklikeMemberid = pClicklikeMemberid == null ? null : pClicklikeMemberid.trim();
    }

    public Integer getpTypeId() {
        return pTypeId;
    }

    public void setpTypeId(Integer pTypeId) {
        this.pTypeId = pTypeId;
    }

    public Integer getpMemberId() {
        return pMemberId;
    }

    public void setpMemberId(Integer pMemberId) {
        this.pMemberId = pMemberId;
    }

	@Override
	public String toString() {
		return "TPhoto [pId=" + pId + ", pName=" + pName + ", pCreatetime=" + pCreatetime + ", pModitytime="
				+ pModitytime + ", pUrl=" + pUrl + ", pDescription=" + pDescription + ", pLikenum=" + pLikenum
				+ ", pClicklikeMemberid=" + pClicklikeMemberid + ", pTypeId=" + pTypeId + ", pMemberId=" + pMemberId
				+ "]";
	}
}