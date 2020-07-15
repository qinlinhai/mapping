package com.qwz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qwz.mapper")
public class ApplicationRun9010 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun9010.class,args);
    }
}
