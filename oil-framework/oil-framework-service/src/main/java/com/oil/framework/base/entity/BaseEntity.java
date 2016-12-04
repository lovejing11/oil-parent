package com.oil.framework.base.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**基础Entity
 * @Version: 1.0
 * @ProjectName:aikxian-framework-service
 * @Filename:  BaseEntity.java
 * @PackageName: com.aikxian.framework.pub.entity
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日下午12:13:46
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public abstract class BaseEntity implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3117938427434991600L;

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

}
