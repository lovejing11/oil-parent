package com.oil.framework.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**序列化工具
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  SerializeUtil.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年5月30日下午1:47:15
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class SerializeUtil {
				public static byte[] serialize(Object object) {
								ObjectOutputStream oos = null;
								ByteArrayOutputStream baos = null;
								try {
												//序列化
												baos = new ByteArrayOutputStream();
												oos = new ObjectOutputStream(baos);
												oos.writeObject(object);
												byte[] bytes = baos.toByteArray();
												return bytes;
								} catch (Exception e) {
												e.printStackTrace();
								}
								return null;
				}

				public static Object unserialize(byte[] bytes) {
								ByteArrayInputStream bais = null;
								try {
												//反序列化
												bais = new ByteArrayInputStream(bytes);
												ObjectInputStream ois = new ObjectInputStream(bais);
												return ois.readObject();
								} catch (Exception e) {
								}
								return null;
				}
}
