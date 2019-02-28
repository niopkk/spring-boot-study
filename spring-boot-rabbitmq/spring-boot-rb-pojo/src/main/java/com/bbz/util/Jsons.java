package com.bbz.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

public interface Jsons {

    /**
     * 对象转换json字符串
     *
     * @param object 需要转换json的对象
     * @return String  json字符串
     */
    static String toJson(Object object) {
        String result = "";
        try {
            if ( object != null ) {
                result = JSONObject.toJSONString (object);
            }
        } catch (Exception e) {
            e.printStackTrace ( );

        }
        return result;
    }

    static String gsonToJson(Object object) {
        String result = "";
        try {
            if ( object != null ) {
                result = new Gson ( ).toJson (object);
            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return result;
    }

    /**
     * json字符串转换为对象
     *
     * @param json 源数据
     * @param cls  需要转换的类型
     * @return T  返回对应的数据
     */
    static <T> T fromJson(String json, Class<T> cls) {
        T t = null;
        try {
            t = JSON.parseObject (json, cls);
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return t;
    }

}
