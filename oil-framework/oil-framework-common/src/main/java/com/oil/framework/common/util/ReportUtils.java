package com.oil.framework.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * 
 * @Version: TODO
 * @ProjectName:com.aikxian.framework.common.uitl
 * @Filename: ReportUtils.java
 * @PackageName: com.aikxian.av.web.admin.controller
 * @Author: 蔡相伟
 * @Email: caixiangwei@aikxian.com
 * @Date:2016年6月6日下午3:12:46
 */
public class ReportUtils {
				//private static Log logger = LogFactory.getLog(ReportUtils.class);

				/**
				 * 数据过滤
				 * 
				 * @param obj
				 * @return
				 */
				public static int[] filterData(int[] obj) {
								for (int i = 1; i <= obj.length - 1; i++) {
												if (obj[i] == 0) {
																obj[i] = obj[i - 1];
												}
								}
								return obj;
				}

				/**
				 * 取得指定年月的当月总天数
				 * 
				 * @param year
				 *            年
				 * @param month
				 *            月
				 * @return 当月总天数
				 */
				public static int getLastDay(int year, int month) {
								int day = 1;
								Calendar cal = Calendar.getInstance();
								cal.set(year, month - 1, day);
								int last = cal.getActualMaximum(Calendar.DATE);
								return last;
				}

				/**
				 * 模拟时间轴
				 * 
				 * @return
				 */
				public static List<String> dateutlis(String type) {
								List<String> list = new ArrayList<String>();
								if (type.equals("hours")) {
												for (int i = 0; i <= 1380; i += 60) {
																String ss = String.format("%02d", i / 60) + ":" + String.format("%02d", i % 60);
																list.add(ss);
												}
												return list;
								} else if (type.equals("days")) {
												for (int i = 1; i <= getDayOfMonth(); i++) {
																list.add("" + i);
												}
												return list;
								}
								return null;
				}

				/**
				 * 格式化日期
				 * @param type
				 * @param monthAmount  得到哪个月份
				 * @param dayAmount  得到那一天
				 * @return
				 */
				public static String dateFormat(String type, int monthAmount, int dayAmount) {
								SimpleDateFormat sf = new SimpleDateFormat(type);
								Calendar calendar = Calendar.getInstance();
								calendar.add(Calendar.DATE, dayAmount);
								calendar.add(Calendar.MONTH, monthAmount);
								return sf.format(calendar.getTime());
				}

				/**
				 * 格式化日期
				 * @param type
				 * @param date
				 * @return
				 */
				public static String dateFormat2(String type, Date date) {
								SimpleDateFormat sf = new SimpleDateFormat(type);
								return sf.format(date);
				}
				/**
				 * 格式化日期
				 * @param type
				 * @param date
				 * @return
				 * @throws ParseException 
				 */
				public static String StrDateFormat(String type, String date) throws ParseException {
								SimpleDateFormat sf = new SimpleDateFormat(type);
								Date parse = sf.parse(date);
								return sf.format(parse);
				}
				/**
				 * 获取当月最大天数
				 * @return
				 */
				public static int getDayOfMonth() {
								Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
								int day = aCalendar.getActualMaximum(Calendar.DATE);
								return day;
				}
				
				/**
				 * 屏蔽账户ID
				 * @return
				 */
				public static List<String> filterID() {
					List<String> removeID = new ArrayList<>();
					removeID.add("383411297");
					removeID.add("10000091");
					return removeID;
				}

				public static void main(String[] args) {
					int total=20,  n=10;
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
			            	//本次值  不大于平均值   最大为平均值  
			                int base = r.nextInt(ave - 1) + 1;
			                array[i] += base;
			                //平均值减去本次值  产生一个基数  
			                int temp = ave - base;
			                //利用这个基数生产一个随机数
			                int temp1 = r.nextInt(temp);
			                //把这个随机金额付给数组  保证此次赋值不会超过平均数  
			                array[r.nextInt(n)] += temp1;
			                //如果还有剩余  则全部赋值给 另一个数组
			                int temp2 = temp - temp1;
			                array[r.nextInt(n)] += temp2;
			            }
			            int t = total - (ave * n);
			            array[r.nextInt(n)] += t;
			        }
								//System.out.println(ReportEnum.RoomState.getName("over"));
				}
}
