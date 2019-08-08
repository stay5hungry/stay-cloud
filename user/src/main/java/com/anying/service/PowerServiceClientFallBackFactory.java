package com.anying.service;

import com.anying.util.R;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/30 16:45
 */
//@Component
public class PowerServiceClientFallBackFactory  implements FallbackFactory<PowerServiceClientV2> {
    @Override
    public PowerServiceClientV2 create(Throwable throwable) {
        return new PowerServiceClientV2() {
            @Override
            public Object power(String name) {
                String message = throwable.getMessage();
                return R.error("feign降级");
            }
        };
    }
}
