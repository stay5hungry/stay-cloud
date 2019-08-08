package com.anying.service;

import com.anying.util.R;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/30 16:41
 */
@Component
public class PowerfeignFallBack implements PowerFeignClient {

    @Override
    public Object getPower() {
        return R.error("power服务暂时不可用");
    }

    @Override
    public Object getPowerList() {
        return R.error("getPowerList暂时不可用");
    }
}
