package com.oil.framework.common.util;



/**sql数据类型转换类
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  SqlDataConvertUtil.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日上午11:36:54
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class SqlDataConvertUtil {

    private static final String convert = "?";

    /**
     * like操作需要做转义处理(左右模糊)
     * @param data 
     * @return data
     */
    public static String like(String data) {
        if (data != null && !"".equals(data)) {
            data = rewrite(data);

        }
        return data;
    }

    //    /**
    //     * 右模糊 
    //     * @param data
    //     * @return
    //     */
    //    public static String likeRight(String data) {
    //        if (data != null && !"".equals(data)) {
    //            data = rewrite(data);
    //            data = data + "%";
    //            data += " ESCAPE'?'";
    //        }
    //        return data;
    //    }
    //
    //    /**
    //     * 左模糊
    //     * @param data
    //     * @return
    //     */
    //    public static String likeLeft(String data) {
    //        if (data != null && !"".equals(data)) {
    //            data = rewrite(data);
    //            data = "%" + data;
    //            data += " ESCAPE'?'";
    //        }
    //        return data;
    //    }

    /**
     * 
     * @param data 
     * @return data
     */
    private static String rewrite(String data) {
        if (data != null && !"".equals(data)) {
            if (data.contains("\\") || data.contains("%") || data.contains("_")) {
                data = data.replace("\\", convert + "\\").replace("%", convert + "%")
                    .replace("_", convert + "_");
            }
        }
        return data;
    }

}
