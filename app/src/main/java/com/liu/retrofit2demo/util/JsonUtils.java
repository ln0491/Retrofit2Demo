package com.liu.retrofit2demo.util;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/19 0019 17:33
 */
public class JsonUtils {

    /**
     * 转换为对象
     * @param jsonString
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String jsonString,Class<T> cls){
        T  t = null;

        t = JSON.parseObject(jsonString,cls);

        return  t;
    }
}
