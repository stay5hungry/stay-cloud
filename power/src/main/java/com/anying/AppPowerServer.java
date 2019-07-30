package com.anying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/22 17:58
 */
@SpringBootApplication
@EnableEurekaClient
public class AppPowerServer {
    public static void main(String[] args) {
        SpringApplication.run(AppPowerServer.class);
    }
}
