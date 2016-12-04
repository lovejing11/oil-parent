package com.oil.framework.common.util;


import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;

/**
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  CustomBigDecimalEditor.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日上午11:33:15
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class CustomBigDecimalEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Object value = getValue();
        return (value != null ? value.toString() : "");
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null||"".equals(text.trim())) {
            setValue(null);
        } else {
            String value = text.trim();
            if (value.indexOf(".") != -1) {
                setValue(BigDecimal.valueOf(Double.parseDouble(value)));
            } else {
                setValue(BigDecimal.valueOf(Long.parseLong(value)));
            }

        }
    }
}
