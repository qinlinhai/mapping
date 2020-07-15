package com.qwz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication6083 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication6083.class,args);
    }
}
