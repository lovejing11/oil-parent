package com.oil.framework.common.page;

import java.io.Serializable;
import java.util.List;

/**分页工具类
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  Pagination.java
 * @PackageName: com.aikxian.framework.common.page
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日下午12:17:24
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class Pagination<T> extends SimplePage implements Serializable {
				private static final long serialVersionUID = 1L;
				/**
				 * 分页内容
				 */
				private List<?> data;
				/**
				 * 分页查询对象的类型
				 */
				private T condition;

				/**
				 * 分页
				 */
				public Pagination() {
								super();
				}

				/**
				 * 构建一个总数和list的构造函数
				 * @param totals 
				 * @param data 
				 */
				public Pagination(Integer totals, List<T> data) {
								this.setRecordsTotal(totals);
								this.data = data;
				}

				/**
				 * 
				 * 构建一个空的<code>Pagination.java</code>
				 * @param draw 
				 * @param pageSize 每页条数
				 * @param total 总页数
				 * @param data 
				 * @param startIndex 
				 */
				public Pagination(int pageNumber, int pageSize) {
								this.pageNumber = pageNumber;
								this.startIndex = pageNumber * pageSize;
								this.pageSize = pageSize;
				}

				/**
				 * 
				 * 构建一个空的<code>Pagination.java</code>
				 * @param draw 
				 * @param pageSize 每页条数
				 * @param total 总页数
				 * @param data 
				 * @param startIndex 
				 */
				public Pagination(int startIndex, int pageSize, int draw, int total, List<?> data) {
								super(startIndex, pageSize, draw, total);
								this.data = data;
				}

				/**
				 * 获取分页内容
				 * @return data
				 */
				public List<?> getData() {
								return data;
				}

				/**
				 * 设置分页内容
				 * @param data  分页内容
				 */
				public void setData(List<?> data) {
								this.data = data;
				}

				/**
				 * 获得分页查询的对象类型
				 * @return condition
				 */
				public T getCondition() {
								return condition;
				}

				/**
				 * 设置分页查询的对象类型
				 * @param condition 
				 */
				public void setCondition(T condition) {
								this.condition = condition;
				}

				/**
				 * 重写toString 输出参数
				 * @return
				 * @see java.lang.Object#toString()
				 */
				public String toString() {
								if (condition != null) {
												return condition.toString();
								}
								return null;
				}
}
