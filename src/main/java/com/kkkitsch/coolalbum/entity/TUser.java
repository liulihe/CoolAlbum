package com.kkkitsch.coolalbum.entity;

public class TUser {

    private Integer uId;

    private String uAccountname;

    private String uNickname;

    private String uPassword;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuAccountname() {
        return uAccountname;
    }

    public void setuAccountname(String uAccountname) {
        this.uAccountname = uAccountname == null ? null : uAccountname.trim();
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname == null ? null : uNickname.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    @Override
    public String toString() {
        return "TUser [uId=" + uId + ", uAccountname=" + uAccountname + ", uNickname=" + uNickname + ", uPassword="
                + uPassword + "]";
    }
}
