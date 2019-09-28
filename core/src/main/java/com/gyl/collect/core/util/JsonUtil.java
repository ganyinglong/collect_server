package com.gyl.collect.core.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Collection;

public class JsonUtil {

    public static String toJsonDefaultDateFormat(Object o) {
        return toJsonWithDateFormat(o, DateUtil.YYYY_MM_DD_HH_MM_SS);
    }

    public static String toJsonWithDateFormat(Object o, String partten) {
        if (o == null) {
            return "{}";
        }
        String os;
        if (o instanceof Collection || o.getClass().isArray()) {
            os = JSONArray.toJSONStringWithDateFormat(o, partten);
        } else {
            os = JSONObject.toJSONStringWithDateFormat(o, partten);
        }
        return os;

    }
}
