package com.oil.framework.common.util;

import java.util.UUID;

/**
 * UUID封装类
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  UUIDS.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: zhaopeng 赵鹏
 * @Email: zhaopeng@aikxian.com
 * @Date:2016年5月5日下午5:15:43
 * @Copyright (c) 2016, dev@aikxian.com All Rights Reserved.
 */
public final class UUIDS{
	
	/**
	 * 去除UUID中-，长度为32位，并且为大写
	 */
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
}
