package com.gyl.collect.core.util;

import java.util.UUID;

public class UUIDUtil {
    public static String uuidString() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
