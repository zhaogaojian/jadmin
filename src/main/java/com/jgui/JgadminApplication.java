package com.jgui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan({ "com.jgui.dao"})
@SpringBootApplication
public class JgadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(JgadminApplication.class, args);
    }

}
