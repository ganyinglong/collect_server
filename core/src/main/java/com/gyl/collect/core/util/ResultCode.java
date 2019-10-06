package com.gyl.collect.core.util;

public enum ResultCode {


    SUCCESS("000000", "成功"),
    BUSINESS_EXCEPTION("500000", "系统繁忙");
    String code;
    String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

}
