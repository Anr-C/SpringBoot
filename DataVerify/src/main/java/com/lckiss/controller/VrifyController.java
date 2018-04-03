package com.lckiss.controller;

import com.lckiss.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 这个案例包括 模板引擎 资源访问
 */
@Controller
public class VrifyController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("user")
    @ResponseBody
    public User user(@Valid User user) {
        //TODO 具体业务逻辑
        return user;
    }

}