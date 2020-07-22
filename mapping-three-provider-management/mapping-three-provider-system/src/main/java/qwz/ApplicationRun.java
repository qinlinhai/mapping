package com.qwz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author WCX
 * @data 2020/7/15 17:20
 * @describe
 */
@SpringBootApplication
@MapperScan("com.qwz.mapper")
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class,args);
    }
}
