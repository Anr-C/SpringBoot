package com.lckiss.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    private Integer id;

    //验证不为空
    //验证长度2-8
    @NotNull(message = "用户名为空")
    @Size(min = 2,max = 8,message = "用户长度2-8位")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

