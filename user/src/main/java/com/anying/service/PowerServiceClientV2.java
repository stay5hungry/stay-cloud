package com.anying.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/30 16:44
 */
//@FeignClient(value = "SERVER-POWER",fallbackFactory =PowerServiceClientFallBackFactory.class)
public interface PowerServiceClientV2 {

    @RequestMapping("/power.do")
    public Object power(@RequestParam("name") String name);
}
