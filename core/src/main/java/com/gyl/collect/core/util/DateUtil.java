package com.gyl.collect.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_T_HH_MM_SS_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String HH_MM_SS = "HH:mm:ss";

    public static final Map<String, DateFormat> DATE_FORMAT_MAP = new HashMap<>();
    static {
        DATE_FORMAT_MAP.put(YYYY_MM_DD,new SimpleDateFormat(YYYY_MM_DD));
        DATE_FORMAT_MAP.put(YYYY_MM_DD_HH_MM_SS,new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS));
        DATE_FORMAT_MAP.put(YYYY_MM_DD_T_HH_MM_SS_Z,new SimpleDateFormat(YYYY_MM_DD_T_HH_MM_SS_Z));
        DATE_FORMAT_MAP.put(HH_MM_SS,new SimpleDateFormat(HH_MM_SS));
    }

    public static Date parse(String datestr, String partten) {
        try {
            return new SimpleDateFormat(partten).parse(datestr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String format(Date date){
        return DATE_FORMAT_MAP.get(YYYY_MM_DD_HH_MM_SS).format(date);
    }

    public static String format(Date date,String partten){
        DateFormat dateFormat = DATE_FORMAT_MAP.get(partten);
        if (null==dateFormat){
            return new SimpleDateFormat(partten).format(date);
        }
        return dateFormat.format(date);
    }
}
