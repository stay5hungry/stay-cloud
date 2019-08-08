package com.anying.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/30 16:37
 */
@FeignClient(value = "SERVER-POWER",fallback = PowerfeignFallBack.class)
public interface PowerFeignClient {

    @RequestMapping("/getPower.do")
    public Object getPower();

    @RequestMapping("/getPowerLiset.do")
    public Object getPowerList();
}
