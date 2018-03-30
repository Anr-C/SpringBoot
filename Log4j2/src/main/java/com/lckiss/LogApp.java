package com.lckiss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动方式一 ComponentScan扫描Controller位置
 */
@SpringBootApplication
public class LogApp {
    public static void main(String[] args) {
        SpringApplication.run(LogApp.class, args);
    }

}