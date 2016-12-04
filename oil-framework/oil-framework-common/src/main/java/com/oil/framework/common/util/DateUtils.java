package com.oil.framework.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**时间工具类。
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  DateUtils.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日上午11:31:41
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class DateUtils {
				private static Log logger = LogFactory.getLog(DateUtils.class);
				private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
				private static final DateTimeFormatter DATE_TIME_FORMAT2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
				private static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("yyyyMMdd");
				private static final DateTimeFormatter DATE_TIME_FORMAT3 = DateTimeFormat.forPattern("yyyyMMddHHmmss");
				private static final DateTimeFormatter DATE_FORMAT2 = DateTimeFormat.forPattern("yyyy-MM-dd");

				/**
				* 构建一个空的<code>DateUtils.java</code>
				*/
				private DateUtils() {
								super();
				}

				/**
				* 将日期字符串(yyyy-MM-dd HH:mm:ss.SSS)转换为零点开始的日期(Date)对象。
				* 
				* @param dateStr
				*            日期字符串(yyyy-MM-dd HH:mm:ss.SSS)
				* @return 零点开始的日期(如果参数不合法则返回Null）
				*/
				public static Date dateStr2BeginDate(final String dateStr) {
								if (!StringUtils.isEmpty(dateStr)) {
												return DATE_TIME_FORMAT2.parseDateTime(dateStr + " 00:00:00.000").toDate();
								}
								return null;
				}

				/**
				* 将日期字符串(yyyy-MM-dd HH:mm:ss.SSS)转换为 23点59分59秒999毫秒结束的日期(Date)对象。
				* 
				* @param dateStr
				*            日期字符串(yyyy-MM-dd HH:mm:ss.SSS)
				* @return 23点59分59秒999毫秒结束的日期（如果参数不合法返回Null）
				*/
				public static Date dateStr2EndDate(final String dateStr) {
								if (!StringUtils.isEmpty(dateStr)) {
												return DATE_TIME_FORMAT2.parseDateTime(dateStr + " 23:59:59.999").toDate();
								}
								return null;
				}

				/**
				* 将日期字符串(yyyy-MM-dd HH:mm:ss)转换为日期(Date)对象。
				* 
				* @param dateStr
				*            日期字符串(yyyy-MM-dd HH:mm:ss)
				* @return 日期（如果参数不合法返回Null）
				*/
				public static Date parseDateTime(final String dateStr) {
								if (!StringUtils.isEmpty(dateStr)) {
												return DATE_TIME_FORMAT.parseDateTime(dateStr).toDate();
								}
								return null;
				}

				/**
				 * 将Long类型参数转为datetime返回datetime类型
				 * @param dateLong 时间戳
				 * @return datetime
				 */
				public static Date parseDateTime(final Long dateLong) {
								if (null != dateLong && 0 < dateLong) {
												return parseDateTime(DATE_TIME_FORMAT.print(dateLong));
								}
								return null;
				}

				/**
				* 将日期字符串(yyyy-MM-dd HH:mm:ss.SSS)转换为日期(Date)对象。
				* 
				* @param dateStr
				*            日期字符串(yyyy-MM-dd HH:mm:ss.SSS)
				* @return 日期（如果参数不合法返回Null）
				*/
				public static Date parseDate(final String dateStr) {
								if (!StringUtils.isEmpty(dateStr)) {
												return DATE_TIME_FORMAT2.parseDateTime(dateStr).toDate();
								}
								return null;
				}

				/**
				* 将日期格式为字符串(yyyy-MM-dd HH:mm:ss)。
				* 
				* @param date
				*            日期
				* @return 字符串(yyyy-MM-dd HH:mm:ss)（如果参数为Null则返回空字符串"")
				*/
				public static String formatDateTime(final Date date) {
								if (date != null) {
												return DATE_TIME_FORMAT.print(date.getTime());
								}
								return "";
				}

				/**
				* 将日期格式化为指定格式的字符串。
				* 
				* @param date
				*            日期
				* @param formatStr
				*            格式化字符串
				* @return 格式化后字符串（如果日期为空返回空字符串"", 如果格式化字符串为空则按照yyyy-MM-dd HH:mm:ss进行格式化)
				*/
				public static String formatDateTime(final Date date, final String formatStr) {
								if (date != null) {
												if (!StringUtils.isEmpty(formatStr)) {
																return DateTimeFormat.forPattern(formatStr).print(date.getTime());
												} else {
																return DATE_TIME_FORMAT.print(date.getTime());
												}
								}
								return "";
				}

				/**
				* 将日期字符串(yyyyMMdd)转换为日期(Date)对象。
				* 
				* @param dateStr
				*            日期字符串(yyyyMMdd)
				* @return 日期（如果参数不合法返回Null）
				*/
				public static Date parseDate2(final String dateStr) {
								if (!StringUtils.isEmpty(dateStr)) {
												return DATE_FORMAT.parseDateTime(dateStr).toDate();
								}
								return null;
				}

				/**
				* 将日期字符串(yyyyMMddHHmmss)转换为日期(Date)对象。
				* 
				* @param dateStr
				*            日期字符串(yyyyMMddHHmmss)
				* @return 日期（如果参数不合法返回Null）
				*/
				public static Date parseDate4(final String dateStr) {
								if (!StringUtils.isEmpty(dateStr)) {
												return DATE_TIME_FORMAT3.parseDateTime(dateStr).toDate();
								}
								return null;
				}

				/**
				* 将日期字符串(yyyy-MM-dd)转换为日期(Date)对象。
				* 
				* @param dateStr
				*            日期字符串(yyyy-MM-dd)
				* @return 日期（如果参数不合法返回Null）
				*/
				public static Date parseDate3(final String dateStr) {
								if (!StringUtils.isEmpty(dateStr)) {
												return DATE_FORMAT2.parseDateTime(dateStr).toDate();
								}
								return null;
				}

				/**
				 * 将日期格式化为指定格式的字符串。
				 * @param date
				 *          日期
				 * @return 格式化后的字符串(如果日期为空返回空字符串"", 如果格式化字符串为空则按照yyyy-MM-dd)
				 */
				public static String paresDateToString2(final Date date) {
								String da = "";
								if (null != date) {
												//创建日期格式化对象
												SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
												//格式化当前日期
												da = sdf.format(date);
												// int length = da.length();
												da = da.substring(0, 10);
								}
								return da;
				}
				
				/**
				 * 将日期格式化为指定格式的字符串。
				 * @param date
				 *          日期
				 * @return 格式化后的字符串(如果日期为空返回空字符串"", 如果格式化字符串为空则按照yyyy-MM-dd)
				 */
				public static String paresDateToString3(final Date date) {
								String da = "";
								if (null != date) {
												//创建日期格式化对象
												SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
												//格式化当前日期
												da = sdf.format(date);
								}
								return da;
				}
				
				/**
				 * 将日期格式化为指定格式的字符串。
				 * @param date
				 *          日期
				 * @return 格式化后的字符串(如果日期为空返回空字符串"", 如果格式化字符串为空则按照yyyy-MM-dd)
				 */
				public static String paresDateToString4(final Date date) {
								String da = "";
								if (null != date) {
												//创建日期格式化对象
												SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
												//格式化当前日期
												da = sdf.format(date);
								}
								return da;
				}

				/**
				* 将日期格式化为指定格式的字符串。
				* 
				* @param date
				*            日期
				* @return 格式化后字符串（如果日期为空返回空字符串"", 如果格式化字符串为空则按照yyyy-MM-dd HH:mm:ss进行格式化)
				*/
				public static String paresDateToString(final Date date) {
								if (date != null) {
												return DATE_TIME_FORMAT.print(date.getTime());
								}
								return "";
				}

				/**
				* 将日期天加下
				* @param date 当前日期
				* @param num  增加的天数
				* @return 增加后的日期
				*/
				public static String addDayForDate(final String date, Integer num) {
								Calendar calendar = new GregorianCalendar();
								calendar.setTime(parseDate3(date));
								if (num == null) {
												num = 1;
								}
								calendar.add(Calendar.DATE, num);
								return DATE_FORMAT2.print(calendar.getTimeInMillis());
				}

				/**
				 * 将日期天加下
				 * @param date 当前日期
				 * @param num  增加的天数
				 * @return 增加后的日期
				 */
				public static Date addDayForDate(Date date, Integer num) {
								Calendar calendar = new GregorianCalendar();
								calendar.setTime(date);
								if (num == null) {
												num = 1;
								}
								calendar.add(Calendar.DATE, num);
								return calendar.getTime();
				}

				public static void main(String[] args) {
					System.out.println(formatDateTime(new Date(), "yyyyMMddHHmmssSSS"));
				}
}
