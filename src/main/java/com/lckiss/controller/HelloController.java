package com.lckiss.controller;

import com.lckiss.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController  @Controller +@ResponseBody 它下面所有的方法都返回json格式 验证：将RestController注释后去掉其他两个注释即可
 */
//@Controller
@RestController
public class HelloController {

//    @ResponseBody
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    /**
     * 异常模拟 全局处理 可以每个都加上try catch，但是可以更简单
     * http://localhost:8081/test1
     * @return
     */
    @RequestMapping("/test1")
    public String test1() {
        int i=1/0;

        return "Greetings from test1!";
    }

    /**
     * 异常模拟 2 http://localhost:8081/test2
     * @return
     */
    @RequestMapping("/test2")
    public String test2() {
        try {
            int i=1/0;
        }catch (Exception e){

        }
        return "Greetings from test2!";
    }

    /**
     * 自定义业务异常模拟 2 http://localhost:8081/test3
     * @return
     */
    @RequestMapping("/test3")
    public String test3() throws BusinessException {
       throw new BusinessException(500,"出错了","500异常");
    }

}