package com.oil.framework.common.tuple;

import java.io.Serializable;

/** 三元元组
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  ThreeTuple.java
 * @PackageName: com.aikxian.framework.common.tuple
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年5月4日上午12:04:35
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class ThreeTuple<T, V, K> extends TwoTuple<T, V> implements Serializable {
    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2893633427599189354L;

    public K                  objectThree;

    public ThreeTuple(T objectOne, V objectTwo, K objectThree) {
        super(objectOne, objectTwo);
        this.objectThree = objectThree;
    }
}
