package com.anying.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/23 9:05
 */
@Configuration
public class AppConfig {

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setPort(7000);
        return tomcatServletWebServerFactory;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
