package com.lckiss.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController {
    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    //--------------http://localhost:8080/log?name=test----------log演示
    @RequestMapping("/log")
    @ResponseBody
    public String log(String name) {
        logger.info("----this is  a  log4j2 log-----");
        logger.info("----name is " + name + "--------");
        return name;
    }

}