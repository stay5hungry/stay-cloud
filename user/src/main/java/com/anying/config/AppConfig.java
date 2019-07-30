package com.anying.config;

import com.anying.rule.StayRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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

//    @Bean
//    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
//        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//        tomcatServletWebServerFactory.setPort(7000);
//        return tomcatServletWebServerFactory;
//    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule iRule(){
        return new StayRule();
    }
}
