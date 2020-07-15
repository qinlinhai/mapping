package com.qwz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.qwz.mapper")
public class ApplicationRun9011 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun9011.class,args);
    }
}
