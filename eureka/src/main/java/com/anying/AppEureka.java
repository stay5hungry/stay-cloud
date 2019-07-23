package com.anying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/23 9:41
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka {
    public static void main(String[] args) {
        SpringApplication.run(AppEureka.class);
    }
}
