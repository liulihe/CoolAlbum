package com.kkkitsch.coolalbum.entity;

import java.util.Date;

public class TMessage {
    private Integer mId;

    private Date mCreatetime;

    private String mSponsor;

    private String mContent;

    private Integer mLike;

    private String mStatus;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Date getmCreatetime() {
        return mCreatetime;
    }

    public void setmCreatetime(Date mCreatetime) {
        this.mCreatetime = mCreatetime;
    }

    public String getmSponsor() {
        return mSponsor;
    }

    public void setmSponsor(String mSponsor) {
        this.mSponsor = mSponsor == null ? null : mSponsor.trim();
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent == null ? null : mContent.trim();
    }

    public Integer getmLike() {
        return mLike;
    }

    public void setmLike(Integer mLike) {
        this.mLike = mLike;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus == null ? null : mStatus.trim();
    }

    @Override
    public String toString() {
        return "TMessage [mId=" + mId + ", mCreatetime=" + mCreatetime + ", mSponsor=" + mSponsor + ", mContent="
                + mContent + ", mLike=" + mLike + ", mStatus=" + mStatus + "]";
    }
    
    
}