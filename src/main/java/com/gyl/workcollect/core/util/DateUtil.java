package com.gyl.workcollect.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date parse(String datestr, String partten)  {
        try {
            return new SimpleDateFormat(partten).parse(datestr);
        } catch (ParseException e) {
            return null;
        }
    }
}
