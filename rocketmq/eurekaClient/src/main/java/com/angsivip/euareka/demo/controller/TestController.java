package com.angsivip.euareka.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 尹碧波  Created in 2020/5/8 15:45
 */
@RestController
public class TestController {


    @Value("${server.port}")
    String port;

    @GetMapping("/test")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
