package com.oil.framework.common.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  DataUtil.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: zhaopeng 赵鹏
 * @Email: zhaopeng@aikxian.com
 * @Date:2016年5月20日下午1:47:15
 * @Copyright (c) 2016, dev@aikxian.com All Rights Reserved.
 */
public class DataUtil {

    /**
     * 生成随机数组
     * @param total 总和
     * @param n     数组长度
     * @return
     */
    public static int[] genRands(int total, int n) {
        int ave = total / n;
        int[] array = new int[n];
        Random r = new Random();
        if (ave < 1) { //平均数小于1，这种情况基本不会出现
            for (int i = 0; i < total; i++) {
                array[i] += 1;
            }
        } else if (ave == 1) { //平均数等于1
            for (int i = 0; i < n; i++) {
                array[i] += 1;
            }
            int y = total % n;
            if (y > 0) { //如果有余数的情况
                for (int i = 0; i < y; i++) {
                    array[r.nextInt(n)] += 1;
                }
            }
        } else { //平均数大于1
            for (int i = 0; i < n; i++) {
                int base = r.nextInt(ave - 1) + 1;
                array[i] += base;
                int temp = ave - base;
                int temp1 = r.nextInt(temp);
                array[r.nextInt(n)] += temp1;
                int temp2 = temp - temp1;
                array[r.nextInt(n)] += temp2;
            }
            int t = total - (ave * n);
            array[r.nextInt(n)] += t;
        }
        return array;
    }

    /**
     * 判断字符串中是否为整数
     * @param str
     * @return
     * 注意：如果字符串为空的，返回也为true
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断字符串中是否为数字,包括小数
     * @param str
     * @return
     * 注意：如果字符串为空的，返回也为true
     */
    public static boolean isNumber(String str) {
        try {
            Double result = Double.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /***
     * 生成多少位的随机数
     * @param pwd_len
     * @return
     */
    public static String genRandomNum(int pwd_len) {
        final int maxNum = 36;
        int i;
        int count = 0;
        char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwd_len) {
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }

    /**
     * java生成随机数字和字母组合
     * 
     * @param length
     *            [生成随机数的长度]
     * @return
     */
    public static String getCharAndNumr(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                //取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /***
     * 将表情转成“#”
     * @param content  需要转换的内容
     * @return
     */
    public static String excuteEmoji(String content) {
        char[] cs = content.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char s = cs[i];
            byte[] bs = String.valueOf(s).getBytes();
            if (3 != bs.length && 63 == bs[0]) {
                cs[i] = '#';
            }
        }
        return String.valueOf(cs); //处理后的消息重新赋值
    }

    public static String excuteEmoji1(String content) {
        char[] cs = content.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char s = cs[i];
            byte[] bs = String.valueOf(s).getBytes();
            if (3 != bs.length && 63 == bs[0]) {
                cs[i] = ' ';
            }
        }
        return String.valueOf(cs); //处理后的消息重新赋值
    }

    /**
     * 过滤特殊字符
     * 只保一下内容
     * 留英文字母（大小写）
     * 数字
     * 汉字
     * @param content
     * @return
     */
    public static String filterSpecialChat(String content) {
        if (null == content) {
            return null;
        }
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]|[a-zA-Z0-9]|[~！@#￥%……&*（）——+·`!$%^()_]");
        Matcher matcher = pattern.matcher(content);
        StringBuffer str = new StringBuffer();
        while (matcher.find()) {
            str.append(matcher.group());
        }
        if (str.length() > 0) {
            return str.toString(); //处理后的消息重新赋值            
        } else {
            return "";
        }
    }

    /***
     * 将客户端传过来的版本号转换成Double类型，便于版本比较
     * @param version  版本号
     * @return
     */
    public static Double getVersion(String version) {
        String v = version.replace(".", ""); //将版本去"."，
        return Double.valueOf(v);//转换Double类型

    }

}
