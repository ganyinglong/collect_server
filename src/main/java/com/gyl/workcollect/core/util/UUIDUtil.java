package com.gyl.workcollect.core.util;

import java.util.UUID;

public class UUIDUtil {
    public static String uuidString() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
