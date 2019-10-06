package com.gyl.collect.common.mvcadvice;

import com.gyl.collect.core.exception.MessageException;
import com.gyl.collect.core.util.BaseResult;
import com.gyl.collect.core.util.LogUtil;
import com.gyl.collect.core.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @Autowired
    private Environment env;

    @ResponseBody
    @ExceptionHandler({IllegalArgumentException.class})
    public BaseResult illegalException(HttpServletRequest request, HttpServletResponse response, Throwable t) {
        return new BaseResult(ResultCode.BUSINESS_EXCEPTION);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseResult exception(HttpServletRequest request, HttpServletResponse response, Throwable t) {
        LogUtil.error("", t);
        return new BaseResult(ResultCode.BUSINESS_EXCEPTION);
    }

    @ResponseBody
    @ExceptionHandler(MessageException.class)
    public BaseResult messageException(Throwable t) {
        LogUtil.error(t.getMessage(), t);
        return new BaseResult(ResultCode.BUSINESS_EXCEPTION.getCode(), t.getMessage());
    }
}
