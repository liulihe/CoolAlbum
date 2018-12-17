package com.kkkitsch.coolalbum.entity;

public class TMember {
    private Integer mId;

    private String mAccountname;

    private String mNickname;

    private String mPassword;

    private String mEmail;

    private String mPhone;

    private String mCreatetime;

    private String mSignature;

    private String mStatus;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmAccountname() {
        return mAccountname;
    }

    public void setmAccountname(String mAccountname) {
        this.mAccountname = mAccountname == null ? null : mAccountname.trim();
    }

    public String getmNickname() {
        return mNickname;
    }

    public void setmNickname(String mNickname) {
        this.mNickname = mNickname == null ? null : mNickname.trim();
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword == null ? null : mPassword.trim();
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail == null ? null : mEmail.trim();
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone == null ? null : mPhone.trim();
    }

    public String getmCreatetime() {
        return mCreatetime;
    }

    public void setmCreatetime(String mCreatetime) {
        this.mCreatetime = mCreatetime == null ? null : mCreatetime.trim();
    }

    public String getmSignature() {
        return mSignature;
    }

    public void setmSignature(String mSignature) {
        this.mSignature = mSignature == null ? null : mSignature.trim();
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus == null ? null : mStatus.trim();
    }

	@Override
	public String toString() {
		return "TMember [mId=" + mId + ", mAccountname=" + mAccountname + ", mNickname=" + mNickname + ", mPassword="
				+ mPassword + ", mEmail=" + mEmail + ", mPhone=" + mPhone + ", mCreatetime=" + mCreatetime
				+ ", mSignature=" + mSignature + ", mStatus=" + mStatus + "]";
	}
    
}