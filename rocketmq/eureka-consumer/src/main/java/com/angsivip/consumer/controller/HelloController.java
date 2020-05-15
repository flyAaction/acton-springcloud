package com.angsivip.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: 尹碧波  Created in 2020/5/8 16:03
 */
@RestController
public class HelloController {
    //使用 LoadBalancerClient
    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate;

    // BalancerClient
    @GetMapping("helloLoadBalancerClient")
    public String helloLoadBalancerClient(@RequestParam String name) {
        name += "!";
        ServiceInstance instance = client.choose("eureka-producer");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/test/?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

    // Spring Cloud Ribbon
    @GetMapping("hello")
    public String hello(@RequestParam String name) {
        name += "!";
        String url = "http://eureka-producer/test/?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }


    // Feign
    @GetMapping("helloFeign")
    public String helloFeign(@RequestParam String name) {
        name += "!";
        String url = "http://eureka-producer/test/?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

}
