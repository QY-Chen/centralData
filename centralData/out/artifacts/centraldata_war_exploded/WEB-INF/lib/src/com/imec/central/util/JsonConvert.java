package com.imec.central.util;

import com.alibaba.fastjson.JSON;

public class JsonConvert {

    /**
     *将对象解析成JSON
     */
    public static <T> String parseToJson(T object){
        return JSON.toJSONString(object);
    }
}
