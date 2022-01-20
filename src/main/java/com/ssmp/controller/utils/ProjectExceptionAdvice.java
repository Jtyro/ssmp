package com.ssmp.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author sheep
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R doOtherException(Exception e){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,e对象发送给开发人员
        e.printStackTrace();
        return new R("系统错误，请稍后再试！");
    }
}
