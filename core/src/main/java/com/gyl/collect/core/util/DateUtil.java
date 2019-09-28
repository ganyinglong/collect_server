package com.gyl.collect.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String YYYY_MM_DD = "yyyy-MM -dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_T_HH_MM_SS_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static Date parse(String datestr, String partten) {
        try {
            return new SimpleDateFormat(partten).parse(datestr);
        } catch (ParseException e) {
            return null;
        }
    }
}
