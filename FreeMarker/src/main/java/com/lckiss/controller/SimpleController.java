package com.lckiss.controller;

import com.lckiss.config.AliConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个案例包括 模板引擎 拦截器 自定义Config属性读取
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
        request.setAttribute("name","lckiss");

        List<String> userList=new ArrayList<String>();
        userList.add("张三");
        userList.add("李四");
        userList.add("王二");
        userList.add("麻子");

        request.setAttribute("userList",userList);
        return "data";
    }

    //------登录演示 http://localhost:8080/login 拦截器开启的状态下只有先访问login方法后才能访问data方法
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request) {
        //模拟成功后返回的session
        request.getSession().setAttribute("name","testUser");
        return "login success";
    }

    //------模拟三方参数获取 http://localhost:8080/customConfig
    @Autowired
    private AliConfig aliConfig;

    @RequestMapping("/customConfig")
    @ResponseBody
    public String customConfig() {
        return "customConfig:key "+aliConfig.getKey()+" appid: "+aliConfig.getAppId();
    }
}