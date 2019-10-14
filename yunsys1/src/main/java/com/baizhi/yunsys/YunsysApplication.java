package com.baizhi.yunsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.yunsys.dao")
public class YunsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunsysApplication.class, args);
    }

}
