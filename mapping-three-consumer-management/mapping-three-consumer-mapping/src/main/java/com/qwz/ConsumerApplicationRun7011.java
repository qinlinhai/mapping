package com.qwz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @author  qlh
 * @date   2020/7/21
 * @desc
 **/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerApplicationRun7011 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplicationRun7011.class,args);
    }
}
