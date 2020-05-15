package com.angsivip.eureka.producer;

import org.springframework.stereotype.Component;

/**
 * 降级-回调类
 *
 * @author: 尹碧波  Created in 2020/5/8 16:39
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {


    @Override
    public String helloFeign(String name) {
        return "hello world !!!";
    }
}
