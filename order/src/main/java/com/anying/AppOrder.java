package com.anying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/30 17:13
 */
@SpringBootApplication
@EnableEurekaClient
public class AppOrder {

    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class);
    }
}
