package com.oil.framework.common.page;

import java.io.Serializable;
import java.util.Map;

/**翻页请求
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  PaginationRequest.java
 * @PackageName: com.aikxian.framework.common.page
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日下午12:17:50
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class PaginationRequest implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long         serialVersionUID = -4365219895806065046L;

    /**
     * 页面绘制次数
     */
    private int                       draw;

    /**
     * 数据开始标识
     */
    private int                       start;

    /**
     * 数据长度
     */
    private int                       length;

    /**
     * 请求条件
     */
    private Map<String, Serializable> params;

    /**
     * 取得页面绘制次数
     * 
     * @return 页面绘制次数
     */
    public int getDraw() {
        return draw;
    }

    /**
     * 设定页面绘制次数
     * 
     * @param draw
     *            页面绘制次数
     */
    public void setDraw(int draw) {
        this.draw = draw;
    }

    /**
     * 取得数据开始标识
     * 
     * @return 数据开始标识
     */
    public int getStart() {
        return start;
    }

    /**
     * 设定数据开始标识
     * 
     * @param start
     *            数据开始标识
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 取得数据长度
     * 
     * @return 数据长度
     */
    public int getLength() {
        return length;
    }

    /**
     * 设定数据长度
     * 
     * @param length
     *            数据长度
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * 取得请求条件
     * 
     * @return 请求条件
     */
    public Map<String, Serializable> getParams() {
        return params;
    }

    /**
     * 设定请求条件
     * 
     * @param params
     *            请求条件
     */
    public void setParams(Map<String, Serializable> params) {
        this.params = params;
    }

    /**
     * 调整检索条件的开始索引，以避免请求的开始索引大于总件数。 同时通过返回值来判断后续检索是否应该继续。
     * 
     * @param recordsTotal
     *            总件数
     * @param response
     *            分页响应
     * @return 是否应该继续检索
     */
    public boolean adjust(int recordsTotal, PaginationResponse<?> response) {
        boolean adjustResult = true;
        if (recordsTotal == 0) {
            this.start = 0;
            adjustResult = false;
        } else if (this.start >= recordsTotal) {
            if (recordsTotal % this.length == 0) {
                this.start = (recordsTotal / this.length - 1) * this.length;
            } else {
                this.start = (recordsTotal / this.length) * this.length;
            }
        }
        response.setStartIndex(this.start);
        response.setRecordsTotal(recordsTotal);
        return adjustResult;
    }

}
