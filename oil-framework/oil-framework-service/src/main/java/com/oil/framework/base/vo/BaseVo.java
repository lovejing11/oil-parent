package com.oil.framework.base.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import com.oil.framework.common.page.Pagination;


/**BaseVo
 * @Version: 1.0
 * @ProjectName:aikxian-framework-service
 * @Filename:  BaseVo.java
 * @PackageName: com.aikxian.framework.pub.vo
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日下午12:14:36
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public abstract class BaseVo implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * 重写toString() 方法 
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> cls = this.getClass();
            // 获取属性列表
            Field[] fs = cls.getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {

                try {
                    Field f = fs[i];
                    //不对serialVersionUID进行输出,别删除,周利均
                    if ("serialVersionUID".equals(f.getName())) {
                        continue;
                    }
                    // 获取属性get方法
                    Method method = cls.getMethod(this.toGetter(f.getName()));
                    Object val = method.invoke(this);
                    sb.append("name:" + f.getName() + " value = " + val);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 根据属性名获取get方法名
     * @param fieldname
     * @return
     */
    private String toGetter(String fieldname) {

        if (fieldname == null || fieldname.length() == 0) {
            return null;
        }

        if (fieldname.length() > 2) {
            String second = fieldname.substring(1, 2);
            if (second.equals(second.toUpperCase())) {
                return new StringBuffer("get").append(fieldname).toString();
            }
        }

        fieldname = new StringBuffer("get").append(fieldname.substring(0, 1).toUpperCase())
            .append(fieldname.substring(1)).toString();

        return fieldname;
    }

    /**
     * 页面绘制次数
     */
    protected Integer                         draw   = 0;

    /**
     * 数据开始标识
     */
    protected Integer                         start  = 0;

    /**
     * 数据长度
     */
    protected Integer                         length = 10;

    /**
     * 页数
     */
    protected Pagination<Map<String, Object>> pager;

    /**
         * 
         */
    public BaseVo() {
        pager = new Pagination<Map<String, Object>>();
    }

    /**
     * 
     * @return draw 
     */
    public Integer getDraw() {
        return draw;
    }

    /**
     * 
     * @param draw 
     */
    public void setDraw(Integer draw) {
        this.draw = draw;
        this.pager.setDraw(draw);
    }

    /**
     * 
     * @return start
     */
    public Integer getStart() {
        return start;
    }

    /**
     * 
     * @param start 
     */
    public void setStart(Integer start) {
        this.start = start;
        this.pager.setStartIndex(start);
    }

    /**
     * 
     * @return length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * 
     * @param length 
     */
    public void setLength(Integer length) {
        this.length = length;
        this.pager.setPageSize(length);
    }

    /**
     *  
     * @return pager
     */
    public Pagination<Map<String, Object>> getPager() {
        return pager;
    }

    /**
     * 
     * @param pager 
     */
    public void setPager(Pagination<Map<String, Object>> pager) {
        this.pager = pager;
    }

    /**
     * @param endDate
     * The endDate to set.
     */
    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 查询开始时间
     */
    private java.util.Date startDate;

    /**
     * 
     * @return startDate 
     */
    public java.util.Date getStartDate() {
        return startDate;
    }

    /**
     * 
     * @param startDate 
     */
    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 查询结束时间
     */
    private java.util.Date endDate;

    /**
     * 
     * @return endDate 
     */
    public java.util.Date getEndDate() {
        return endDate;
    }
    
    
    
    private Integer pageNumber;

    /**
     * @return Returns the pageNumber
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber
     * The pageNumber to set.
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
    
}
