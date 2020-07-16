package qwz;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/15 15:04
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.qwz.mapper")
@EnableFeignClients(basePackages = {"com.qwz"})
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class,args);
    }
}
