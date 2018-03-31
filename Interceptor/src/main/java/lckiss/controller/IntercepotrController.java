package lckiss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IntercepotrController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    //-----http://localhost:8080/data---演示数据
    @RequestMapping("/data")
    @ResponseBody
    public List<String> data() {

        List<String> userList=new ArrayList<String>();
        userList.add("张三");
        userList.add("李四");
        userList.add("王二");
        userList.add("麻子");

        return userList;
    }

    //------登录演示 http://localhost:8080/login 拦截器开启的状态下只有先访问login方法后才能访问data方法
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request) {
        //模拟成功后返回的session
        request.getSession().setAttribute("name","testUser");
        return "login success";
    }
}