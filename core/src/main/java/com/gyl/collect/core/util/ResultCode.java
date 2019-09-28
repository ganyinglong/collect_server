package com.gyl.collect.core.util;

public enum ResultCode {


    SUCCESS("000000", "成功");
    String code;
    String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
