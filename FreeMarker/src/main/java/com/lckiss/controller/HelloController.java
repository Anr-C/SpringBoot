package com.lckiss.controller;

import com.lckiss.AliConfig;
import com.lckiss.mapper.master.MasterMapper;
import com.lckiss.mapper.slave.SlaveAlphaMapper;
import com.lckiss.model.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//@EnableScheduling 标记后才支持定时任务
@Controller
@EnableScheduling
public class HelloController {
private final static Logger logger=org.slf4j.LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    //默认模板引擎
    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    //模板引擎-数据渲染
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

    //log演示
    @RequestMapping("/log")
    @ResponseBody
    public String log(String name) {
        logger.info("----this is  a  log4j2 log-----");
        logger.info("----name is "+name+"--------");
        return name;
    }

    //访问多数据源中的第一个数据源
    @Autowired
    private MasterMapper masterMapper;

    @RequestMapping("/master")
    @ResponseBody
    public String master(int id) {
        User user= masterMapper.selectUserById(id);
        return user.getName();
    }


    //访问多数据源中的第二个数据源
    @Autowired
    private SlaveAlphaMapper slaveAlphaMapper;

    @RequestMapping("/slaveAlpha")
    @ResponseBody
    public String slaveAlpha(int id) {
       User user= slaveAlphaMapper.selectUserById(id);
        return user.getName();
    }


    //登录演示
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request) {
        //模拟成功后返回的session
        request.getSession().setAttribute("name","testUser");
        return "login success";
    }


    //模拟三方参数获取
    @Autowired
    private AliConfig aliConfig;

    @RequestMapping("/customConfig")
    @ResponseBody
    public String customConfig() {
        return "customConfig:key "+aliConfig.getKey()+" appid: "+aliConfig.getAppId();
    }
}