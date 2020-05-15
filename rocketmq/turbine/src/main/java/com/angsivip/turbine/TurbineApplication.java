package com.angsivip.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 数据聚合
 *
 * @author: 尹碧波  Created in 2020/5/11 15:53
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApplication {

    // 分别启动
    // eureka-server
    //eureka-producer
    //eureka-consumer-hystrix
    //turbine
    //hystrix-dashboard

    //访问 Hystrix Dashboard 并开启对 http://localhost:8080/turbine.stream 的监控，这

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }

}
