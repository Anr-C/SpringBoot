package com.lckiss.controller;

import com.lckiss.mapper.UserMapper;
import com.lckiss.model.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableCaching//开启缓存的开关
public class CacheController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }


    //------http://localhost:8080/user----使用缓存
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    @ResponseBody
    public String user(int id) {
       User user= userMapper.selectUserById(id);
        return user.toString();
    }

    //-----http://localhost:8080/clearCache-----删除缓存
    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/clearCache")
    @ResponseBody
    public String clearCache(int id) {
        //清除缓存
        cacheManager.getCache("baseCache").clear();
        //重新查询
        User user= userMapper.selectUserById(id);
        return user.toString();
    }


}