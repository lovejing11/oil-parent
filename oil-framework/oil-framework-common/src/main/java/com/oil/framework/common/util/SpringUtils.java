package com.oil.framework.common.util;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**Utils - Spring
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  SpringUtils.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日下午12:10:59
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
@Component("springUtils")
@Lazy(false)
public final class SpringUtils implements ApplicationContextAware, DisposableBean {

    /** applicationContext */
    private static ApplicationContext applicationContext;

    /**
     * 不可实例化
     */
    private SpringUtils() {
    }

    /**
     * @param applicationContext 
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * @throws Exception 
     */
    public void destroy() throws Exception {
        applicationContext = null;
    }

    /**
     * 获取applicationContext
     * 
     * @return applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取实例
     * 
     * @param name
     *            Bean名称
     * @return 实例
     */
    public static Object getBean(String name) {
        Assert.hasText(name);
        return applicationContext.getBean(name);
    }

    /**
     * 获取实例
     * 
     * @param name
     *            Bean名称
     * @param type
     *            Bean类型
     * @return 实例
     * @param <T> 
     */
    public static <T> T getBean(String name, Class<T> type) {
        Assert.hasText(name);
        Assert.notNull(type);
        return applicationContext.getBean(name, type);
    }

}