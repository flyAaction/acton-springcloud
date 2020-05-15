package com.angsivip.eureka.controller;

import com.angsivip.eureka.producer.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 尹碧波  Created in 2020/5/8 16:24
 */
@RequestMapping("feign")
@RestController
public class HelloController {

    @Autowired
    private HelloRemote remote;

    @GetMapping("/{name}")
    public String index(@PathVariable("name") String name) {
        return remote.helloFeign(name);
    }


}
