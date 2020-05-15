package com.angsivip.eureka.producer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient-调用服务
 * fallback-- 服务降级
 *
 * @author: 尹碧波  Created in 2020/5/8 16:26
 */
@FeignClient(name = "eureka-producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @GetMapping("/test/")
    String helloFeign(@RequestParam String name);

}
