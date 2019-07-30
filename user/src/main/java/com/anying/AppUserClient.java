package com.anying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/22 17:52
 */
@SpringBootApplication
@EnableFeignClients
public class AppUserClient {
    public static void main(String[] args) {
        SpringApplication.run(AppUserClient.class);
    }
}
