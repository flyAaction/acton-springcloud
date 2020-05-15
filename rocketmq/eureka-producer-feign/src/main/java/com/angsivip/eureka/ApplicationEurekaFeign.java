package com.angsivip.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: 尹碧波  Created in 2020/5/8 16:24
 */
@SpringBootApplication
@EnableFeignClients
public class ApplicationEurekaFeign {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEurekaFeign.class, args);
    }

}
