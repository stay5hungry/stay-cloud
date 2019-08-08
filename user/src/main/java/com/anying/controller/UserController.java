package com.anying.controller;

import com.anying.service.PowerClientService;
import com.anying.service.PowerFeignClient;
import com.anying.util.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private static final String  POWER_URL="http://SERVER-POWER";
    private static final String  ORDER_URL="http://SERVER-ORDER";

    @Autowired
    RestTemplate restTemplate;

//    @Autowired
//    PowerClientService powerClientService;

    @Autowired
    private PowerFeignClient powerFeignClient;

    @RequestMapping("/getUser.do")
    public R getUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("key","user");
        return R.success("返回成功",map);
    }


    @RequestMapping("/getPower.do")
    public R getPower(){
        return R.success("操作成功",restTemplate.getForObject(POWER_URL+"/getPower.do",Object.class));
    }

    @RequestMapping("/getFeignPower.do")
    public R getFeignPower(){
        System.out.println("调用了Feign");
        return R.success("操作成功",powerFeignClient.getPower());
    }

    @RequestMapping("/getOrder.do")
    public R getOrder(){
        return R.success("操作成功",restTemplate.getForObject(ORDER_URL+"/getOrder.do",Object.class));
    }

    @RequestMapping("/getPower2.do")
    @HystrixCommand(fallbackMethod = "fallbackMethod",threadPoolKey = "power",
            threadPoolProperties ={@HystrixProperty(name = "coreSize",value = "2")
            })
    public R getPower2(){
        System.out.println("调用了方法");
        return R.success("操作成功",restTemplate.getForObject(POWER_URL+"/getPower.do",Object.class));
    }

    public R fallbackMethod(){
        System.out.println("降级了-----------");
        return R.error("降级信息");
    }

}
