package com.anying.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PowerController {

    @RequestMapping("/getPower.do")
    public Object getPower() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("key","power");
//        int i=1/0;
//        Thread.sleep(10000);
        return map;
    }
}
