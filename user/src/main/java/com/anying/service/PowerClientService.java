package com.anying.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/29 11:42
 */
@FeignClient("SERVER-POWER")
public interface PowerClientService {

    @RequestMapping("/getPower.do")
    public Object getPower();
}
