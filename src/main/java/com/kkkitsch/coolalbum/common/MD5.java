package com.kkkitsch.coolalbum.common;

import org.springframework.util.DigestUtils;

public class MD5 {

    /**
     * MD5方法
     * 
     * @param text
     *            明文
     * @param key
     *            密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) {
        return DigestUtils.md5DigestAsHex((text + key).getBytes());
    }

    /**
     * MD5验证方法
     * 
     * @param text
     *            明文
     * @param key
     *            密钥
     * @param md5
     *            密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        // 根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if (md5Text.equalsIgnoreCase(md5)) {
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }
}
