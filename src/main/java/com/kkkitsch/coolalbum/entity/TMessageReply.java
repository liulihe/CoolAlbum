package com.kkkitsch.coolalbum.entity;

import java.util.Date;

public class TMessageReply {
	private String mId;

	private String mSponsorAcct;

	private String mReceiverAcct;

	private String mReplyContent;

	private Date mReplyTime;

	private Date mReplyUpdateTime;

	private String mReplyReferto;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId == null ? null : mId.trim();
	}

	public String getmSponsorAcct() {
		return mSponsorAcct;
	}

	public void setmSponsorAcct(String mSponsorAcct) {
		this.mSponsorAcct = mSponsorAcct == null ? null : mSponsorAcct.trim();
	}

	public String getmReceiverAcct() {
		return mReceiverAcct;
	}

	public void setmReceiverAcct(String mReceiverAcct) {
		this.mReceiverAcct = mReceiverAcct == null ? null : mReceiverAcct.trim();
	}

	public String getmReplyContent() {
		return mReplyContent;
	}

	public void setmReplyContent(String mReplyContent) {
		this.mReplyContent = mReplyContent == null ? null : mReplyContent.trim();
	}

	public Date getmReplyTime() {
		return mReplyTime;
	}

	public void setmReplyTime(Date mReplyTime) {
		this.mReplyTime = mReplyTime;
	}

	public Date getmReplyUpdateTime() {
		return mReplyUpdateTime;
	}

	public void setmReplyUpdateTime(Date mReplyUpdateTime) {
		this.mReplyUpdateTime = mReplyUpdateTime;
	}

	public String getmReplyReferto() {
		return mReplyReferto;
	}

	public void setmReplyReferto(String mReplyReferto) {
		this.mReplyReferto = mReplyReferto == null ? null : mReplyReferto.trim();
	}

	@Override
	public String toString() {
		return "TMessageReply [mId=" + mId + ", mSponsorAcct=" + mSponsorAcct + ", mReceiverAcct=" + mReceiverAcct
				+ ", mReplyContent=" + mReplyContent + ", mReplyTime=" + mReplyTime + ", mReplyUpdateTime="
				+ mReplyUpdateTime + ", mReplyReferto=" + mReplyReferto + "]";
	}

}