package com.kkkitsch.coolalbum.util;

import java.util.Map;

public class MyMsg<T> {

    // 状态码
    private int code;

    // 提示信息
    private String msg;

    // 相应内容
    private T content;

    // 额外的信息
    private Map<String, Object> ext;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    /**
     * 快速的调用成功方法
     */
    public static <T> MyMsg<T> success(String msg, T content, Map<String, Object> ext) {
        MyMsg<T> myMsg = new MyMsg<T>();
        myMsg.setCode(1);
        myMsg.setMsg(msg);
        myMsg.setContent(content);
        myMsg.setExt(ext);
        return myMsg;
    }

    /**
     * 快速的调用失败方法
     */
    public static <T> MyMsg<T> fail(String msg, T content, Map<String, Object> ext) {
        MyMsg<T> myMsg = new MyMsg<T>();
        myMsg.setCode(0);
        myMsg.setMsg(msg);
        myMsg.setContent(content);
        myMsg.setExt(ext);
        return myMsg;
    }

    @Override
    public String toString() {
        return "MyMsg [code=" + code + ", msg=" + msg + ", content=" + content + ", ext=" + ext + "]";
    }

}
