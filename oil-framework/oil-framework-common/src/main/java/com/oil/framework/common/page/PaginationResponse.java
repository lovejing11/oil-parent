package com.oil.framework.common.page;

import java.io.Serializable;
import java.util.List;

/**分页响应。
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  PaginationResponse.java
 * @PackageName: com.aikxian.framework.common.page
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日下午12:18:03
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class PaginationResponse<T extends Serializable> implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3361880448900878720L;

    /**
     * 分页查询的起始行数
     */
    private int               startIndex;

    /**
     * 绘制次数
     */
    private int               draw;

    /**
     * 记录总数
     */
    private int               recordsTotal;

    /**
     * 筛选过滤总数
     */
    private int               recordsFiltered;

    /**
     * 页数
     */
    private int               pageNumber       = 0;

    /**
     * 分页数据
     */
    private List<T>           data;

    /**
     * 取得分页查询的起始行数
     * 
     * @return 分页查询的起始行数
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * 设定分页查询的起始行数
     * 
     * @param startIndex
     *            分页查询的起始行数
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * 取得绘制次数
     * 
     * @return 绘制次数
     */
    public int getDraw() {
        return draw;
    }

    /**
     * 设定绘制次数
     * @param draw 绘制次数
     */
    public void setDraw(int draw) {
        this.draw = draw;
    }

    /**
     * 取得记录总数
     * 
     * @return 记录总数
     */
    public int getRecordsTotal() {
        return recordsTotal;
    }

    /**
     * 设定记录总数
     * 
     * @param recordsTotal
     *            记录总数
     */
    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
    }

    /**
     * 取得筛选过滤总数
     * 
     * @return 筛选过滤总数
     */
    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    /**
     * 取得页数
     * 
     * @return 页数
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * 取得分页数据
     * 
     * @return 分页数据
     */
    public List<T> getData() {
        return this.data;
    }

    /**
     * 设定分页数据
     * 
     * @param data
     *            分页数据
     */
    public void setData(List<T> data) {
        this.data = data;
    }

}
