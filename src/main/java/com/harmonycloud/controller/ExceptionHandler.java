package com.harmonycloud.controller;

import com.harmonycloud.result.CimsResponseWrapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author qidong
 * @date 2019/3/12
 */

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CimsResponseWrapper handler(Exception e) {
        e.printStackTrace();
        return new CimsResponseWrapper(false, null, e.getMessage());

    }
}
