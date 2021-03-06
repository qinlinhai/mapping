package com.qwz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.qwz.mapper")
public class ApplicationRun9011 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun9011.class,args);
    }
}
