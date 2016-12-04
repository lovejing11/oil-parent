package com.oil.framework.common.util;



/**
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  BooleanUtil.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日上午11:30:34
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class BooleanUtil {
    /**
     * 判断是否是数字
     * 
     * @param str 
     * @return str
     */
    public static boolean isNum(String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }
}
