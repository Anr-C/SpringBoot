package com.lckiss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个案例包括 模板引擎 资源访问
 */
@Controller
public class SimpleController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    //-----http://localhost:8080/home---默认模板引擎
    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    //-----http://localhost:8080/data---模板引擎-数据渲染
    @RequestMapping("/data")
    public String data(HttpServletRequest request) {
        request.setAttribute("name", "lckiss");

        List<String> userList = new ArrayList<String>();
        userList.add("张三");
        userList.add("李四");
        userList.add("王二");
        userList.add("麻子");

        request.setAttribute("userList", userList);
        return "data";
    }

}