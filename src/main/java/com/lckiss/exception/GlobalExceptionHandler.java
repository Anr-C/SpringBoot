package com.lckiss.exception;

import com.lckiss.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ControllerAdvice 处理Controller中所有没有被try catch包裹的(比如test1方法) 一个注解
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> handlerExcetion(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",500);
        map.put("msg","系统繁忙，请稍候再试");
        return map;
    }


    //自定义的业务异常处理
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Map<String,Object> handlerBusinessExcetion(BusinessException businessException){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",businessException.getCode());
        map.put("msg",businessException.getMsg());
        map.put("desc",businessException.getDesc());
        return map;
    }

    //自定义的SQL异常处理
    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public Map<String,Object> handlerSQLExcetion(){
        Map<String,Object> map=new HashMap<String,Object>();
        //TODO SQL异常处理逻辑
        return map;
    }
}
