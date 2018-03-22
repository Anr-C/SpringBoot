package com.lckiss.controller;

import com.lckiss.mapper.UserMapper;
import com.lckiss.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * http://localhost:8081/user-detail?id=1
     * @param id
     * @return
     */
    @RequestMapping("user-detail")
    public User selectUserById(int id){
        return  userMapper.selectUserById(id);
    }


    /**
     * http://localhost:8081/insert-user?name=xx
     * @param name
     * @return
     */
    @RequestMapping("insert-user")
    public String insertUser(String name){
          userMapper.insertUser(name);
          return "ok";
    }
}
