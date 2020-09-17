package com.internship.shakeapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.internship.shakeapp.dao")
public class ShakeappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShakeappApplication.class, args);
    }

}
