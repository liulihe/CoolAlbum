package com.kkkitsch.coolalbum.entity;

import java.util.Date;

public class TMessage {
    private Integer mId;

    private Date mCreatetime;

    private String mSponsor;

    private String mContent;

    private Integer mReplyId;

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

    public Integer getmReplyId() {
        return mReplyId;
    }

    public void setmReplyId(Integer mReplyId) {
        this.mReplyId = mReplyId;
    }

	@Override
	public String toString() {
		return "TMessage [mId=" + mId + ", mCreatetime=" + mCreatetime + ", mSponsor=" + mSponsor + ", mContent="
				+ mContent + ", mReplyId=" + mReplyId + "]";
	}
    
    
}