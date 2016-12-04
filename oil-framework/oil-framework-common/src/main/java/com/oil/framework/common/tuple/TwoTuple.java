package com.oil.framework.common.tuple;

import java.io.Serializable;

/**二元元组，用于同时返回两个对象
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  TwoTuple.java
 * @PackageName: com.aikxian.framework.common.tuple
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年5月4日上午12:04:48
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class TwoTuple<T, V> implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2941980455435946533L;

    public T                  objectOne;

    public V                  objectTwo;

    public TwoTuple(T objectOne, V objectTwo) {
        this.objectOne = objectOne;
        this.objectTwo = objectTwo;
    }
}
