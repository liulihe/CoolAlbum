package com.kkkitsch.coolalbum.entity;

import java.util.Date;

public class TMessage{
	private String mId;

	private Integer mMessageReceiverId;

	private String mSponsor;

	private String mContent;

	private Date mCreatetime;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId == null ? null : mId.trim();
	}

	public Integer getmMessageReceiverId() {
		return mMessageReceiverId;
	}

	public void setmMessageReceiverId(Integer mMessageReceiverId) {
		this.mMessageReceiverId = mMessageReceiverId;
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

	public Date getmCreatetime() {
		return mCreatetime;
	}

	public void setmCreatetime(Date mCreatetime) {
		this.mCreatetime = mCreatetime;
	}

	@Override
	public String toString() {
		return "TMessage [mId=" + mId + ", mMessageReceiverId=" + mMessageReceiverId + ", mSponsor=" + mSponsor
				+ ", mContent=" + mContent + ", mCreatetime=" + mCreatetime + "]";
	}
}