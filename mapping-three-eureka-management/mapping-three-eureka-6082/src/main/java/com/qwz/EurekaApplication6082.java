package com.qwz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication6082 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication6082.class,args);
    }
}
