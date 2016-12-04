package com.oil.framework.common.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;

/**
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  BeanCopy.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日上午10:35:34
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class BeanCopy {
				private static Log logger = LogFactory.getLog(BeanCopy.class);
				private static DozerBeanMapper dozer = new DozerBeanMapper();

				/**
				 * 类集合属性的复制
				 * @param listSource 源集合
				 * @param clazz  目标class类型
				 * @param <T> 
				 * @param <S>          
				 * @return listTarget
				 */
				public static <S, T> List<T> listCopy(List<S> listSource, Class<T> clazz) {
								List<T> listTarget = new ArrayList<T>();
								T target = null;
								if (listSource != null && clazz != null) {
												for (S source : listSource) {
																target = (T) BeanUtils.instantiate(clazz);
																BeanUtils.copyProperties(source, target);
																listTarget.add(target);
												}
								}
								return listTarget;
				}

				/**
				 * 类集合属性的复制
				 * 
				 * @param listSource
				 *          源集合
				 * @param clazz
				 *          目标class类型
				 * @param <T> 
				 * @param <S>          
				 * @return listTarget
				 */
				public static <S, T> T[] listCopy(S[] listSource, Class<T> clazz) {
								List<T> listTarget = new ArrayList<T>();
								T target = null;
								if (listSource != null && clazz != null) {
												for (S source : listSource) {
																target = (T) BeanUtils.instantiate(clazz);
																BeanUtils.copyProperties(source, target);
																listTarget.add(target);
												}
								}
								return (T[]) listTarget.toArray();
				}

				/**
				 * 类属性的复制
				 * 
				 * @param <T> 
				 * @param source
				 *          源集合
				 * @param target 
				 * @param <S> 
				 * @return targetCls
				 */
				public static <S, T> T beanCopy(S source, Class<T> target) {
								T targetCls = null;
								if (source != null && target != null) {
												targetCls = (T) BeanUtils.instantiate(target);
												BeanUtils.copyProperties(source, targetCls);
								}
								return targetCls;
				}

				/**
				 * 转换bean属性
				 * @param <T> 
				 * @param source 
				 * @param destinationClass 
				 * @return map 
				 */
				@Deprecated
				public static <T> T map(Object source, Class<T> destinationClass) {
								return dozer.map(source, destinationClass);
				}

				/**
				 * 转换bean属性
				 * 
				 * @param source 
				 * @param destinationObject 
				 */
				@Deprecated
				public static void copy(Object source, Object destinationObject) {
								dozer.map(source, destinationObject);
				}

				/**
				 * map 转化为bean
				 * 
				 * @param map 
				 * @param <T> 
				 * @param t  
				 * @return t
				 */
				public static <T> T transMap2Bean(Map<String, Object> map, T t) {
								try {
												BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
												PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
												for (PropertyDescriptor property : propertyDescriptors) {
																String key = property.getName();
																if (map.containsKey(key)) {
																				Object value = map.get(key);
																				// 得到property对应的setter方法
																				Method setter = property.getWriteMethod();
																				setter.invoke(t, value);
																}
												}
								} catch (Exception e) {
												logger.info("transMap2Bean Error " + e);
								}
								return t;
				}
}
