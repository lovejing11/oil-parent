package com.oil.framework.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/** 数据类型转换工具，
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  JSONUtil.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: zhaopeng 赵鹏
 * @Email: zhaopeng@aikxian.com
 * @Date:2016年5月5日上午11:31:15
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public abstract class JSONUtil {
				private static final ObjectMapper MAPPER = new ObjectMapper();
				private static final JsonFactory JSONFACTORY = new JsonFactory();
				private static Log logger = LogFactory.getLog(JSONUtil.class);

				public static String beanToJson(Object o) {
								StringWriter sw = new StringWriter(300);
								JsonGenerator gen = null;
								try {
												gen = JSONFACTORY.createGenerator(sw);
												MAPPER.writeValue(gen, o);
												return sw.toString();
								} catch (Exception e) {
												throw new RuntimeException("JSON转换失败", e);
								} finally {
												if (gen != null) {
																try {
																				gen.close();
																} catch (IOException ignored) {
																}
												}
								}
				}

				public static <Value> Map<String, Value> beanToMap(Object o) {
								try {
												return (Map) MAPPER.readValue(beanToJson(o), HashMap.class);
								} catch (IOException e) {
												throw new RuntimeException("转换失败", e);
								}
				}

				public static <Object> Map<String, Object> jsonToMap(String json) {
								try {
												return (Map) MAPPER.readValue(json, HashMap.class);
								} catch (IOException e) {
												throw new RuntimeException("转换失败", e);
								}
				}

				/***
				 * json数据转换为list
				 * @param json json串
				 * @param type list的泛型类   
				 * @return list集合
				 */
				public static <T> List<T> jsonToArray(String json, Class<T> type) {
								try {
												JavaType javaType = getCollectionType(ArrayList.class, type);
												return MAPPER.readValue(json, javaType);
								} catch (IOException e) {
												throw new RuntimeException("转换失败", e);
								}
				}

				public static List jsonToArray(String json) {
								try {
												List list = (List) MAPPER.readValue(json, ArrayList.class);
												return list;
								} catch (IOException e) {
												throw new RuntimeException("转换失败", e);
								}
				}

				public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
								return MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
				}

				public static <T> T jsonToBean(String json, Class<T> type) {
								try {
												return (T) MAPPER.readValue(json, type);
								} catch (IOException e) {
												throw new RuntimeException(e);
								}
				}
				static {
								MAPPER.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
								MAPPER.configure(Feature.ALLOW_SINGLE_QUOTES, true);
								MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
								MAPPER.getSerializationConfig().withSerializationInclusion(Include.NON_NULL);
				}

				public static void main(String[] args) {
								List<String> list = new ArrayList<String>();
								list.add("123");
								list.add("234");
								list.add("345");
								list.add("456");
								list.add("567");
								list.add("678");
								logger.info(beanToJson(list));
				}
}
