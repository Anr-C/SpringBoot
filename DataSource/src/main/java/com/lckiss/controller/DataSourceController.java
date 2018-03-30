package com.lckiss.controller;

import com.lckiss.mapper.master.MasterMapper;
import com.lckiss.mapper.slave.SlaveAlphaMapper;
import com.lckiss.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DataSourceController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    //访问多数据源中的第一个数据源 http://localhost:8080/master?id=1
    @Autowired
    private MasterMapper masterMapper;

    @RequestMapping("/master")
    @ResponseBody
    public String master(int id) {
        User user = masterMapper.selectUserById(id);
        return user.toString();
    }


    //访问多数据源中的第二个数据源 http://localhost:8080/slaveAlpha?id=1
    @Autowired
    private SlaveAlphaMapper slaveAlphaMapper;

    @RequestMapping("/slaveAlpha")
    @ResponseBody
    public String slaveAlpha(int id) {
        User user = slaveAlphaMapper.selectUserById(id);
        return user.toString();
    }

}