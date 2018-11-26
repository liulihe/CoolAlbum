package com.kkkitsch.coolalbum.entity;

public class TMember {
    private Integer mId;

    private String mAccountname;

    private String mNickname;

    private String mPassword;

    private String mEmail;

    private String mPhone;

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

	@Override
	public String toString() {
		return "TMember [mId=" + mId + ", mAccountname=" + mAccountname + ", mNickname=" + mNickname + ", mPassword="
				+ mPassword + ", mEmail=" + mEmail + ", mPhone=" + mPhone + "]";
	}
   
    
    
}