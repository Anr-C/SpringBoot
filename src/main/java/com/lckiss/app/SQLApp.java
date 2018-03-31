package com.lckiss.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动方式一 ComponentScan扫描Controller位置
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com/lckiss/controller")
@MapperScan(basePackages = "com/lckiss/mapper")

public class SQLApp {
    public static void main(String[] args) {
        SpringApplication.run(SQLApp.class, args);
    }

}