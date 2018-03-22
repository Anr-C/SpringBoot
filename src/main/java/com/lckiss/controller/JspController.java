package com.lckiss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    /**
     * @return index.jsp
     */
    @RequestMapping("/jsp")
    public String jsp() {
       return "index";
    }

}