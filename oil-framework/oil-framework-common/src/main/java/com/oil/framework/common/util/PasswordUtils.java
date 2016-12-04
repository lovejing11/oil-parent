package com.oil.framework.common.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/** 密码工具类
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  PasswordUtils.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日上午11:36:34
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class PasswordUtils {

    /**
     * SaltPart
     */
    private static final String SALT_PART = "af#42SLJ%DBKPa";

    /**
     * Default encoding
     */
    private static final String DEFAULT_ENCODING = "utf-8";

    /**
     * Used to build output as Hex
     */
    private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f' };

    /**
     * 构建一个空的<code>PasswordUtils.java</code>
     */
    private PasswordUtils() {
        super();
    }

    /**
     * 将byte数组转换成字符串
     * 
     * @param data
     *            byte数组
     * @return 字符串
     */
    public static String encode(byte[] data) {
        int len = data.length;
        char[] out = new char[len << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < len; i++) {
            out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS[0x0F & data[i]];
        }
        return new String(out);
    }

    /**
     * 将原始数据以Salt进行MD5加密
     * @param source 原始数据
     * @param salt Salt
     * @return 加密结果
     */
    public static String digest(String source, byte[] salt) {
        try {
            return new String(encode(digest(source.getBytes(DEFAULT_ENCODING), salt)));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("PasswordCrypter's error has occured!", ex);
        } catch (RuntimeException ex) {
            throw ex;
        }
    }

    /**
     * 将原始数据以Salt进行MD5加密
     * @param source 原始数据
     * @param salt Salt
     * @return 加密结果
     */
    private static byte[] digest(byte[] source, byte[] salt) {
        try {
            MessageDigest md5Digest = MessageDigest.getInstance("md5");
            md5Digest.reset();
            md5Digest.update(salt);
            return md5Digest.digest(source);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("PasswordCrypter's error has occured!", ex);
        }
    }

    /**
     * 以用户名作为Salt加密密码
     * 
     * @param username
     *            用户名
     * @param password
     *            用户密码
     * @return 加密后密码
     */
    public static String cryptPassword(String username, String password) {
        try {
            byte[] saltBytes = createSalt(username).getBytes(DEFAULT_ENCODING);
            byte[] passwordBytes = password.getBytes(DEFAULT_ENCODING);
            return new String(encode(digest(passwordBytes, saltBytes)));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("PasswordCrypter's error has occured!", ex);
        } catch (RuntimeException ex) {
            throw ex;
        }

    }

    /**
     * 通过用户名生成Salt
     * 
     * @param username
     *            用户名
     * @return salt
     */
    public static String createSalt(String username) {
        return username + SALT_PART;
    }

}
