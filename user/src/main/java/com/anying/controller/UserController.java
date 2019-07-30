package com.anying.controller;

import com.anying.service.PowerClientService;
import com.anying.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PowerClientService powerClientService;

    @RequestMapping("/getUser.do")
    public R getUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("key","user");
        return R.success("返回成功",map);
    }


    @RequestMapping("/getPower.do")
    public R getPower(){
        return R.success("操作成功",restTemplate.getForObject("http://SERVER-POWER/getPower.do",Object.class));
    }

    @RequestMapping("/getFeignPower.do")
    public R getFeignPower(){
        System.out.println("调用了Feign");
        return R.success("操作成功",powerClientService.getPower());
    }

}
