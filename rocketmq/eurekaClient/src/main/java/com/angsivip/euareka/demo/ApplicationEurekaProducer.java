package com.angsivip.euareka.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 尹碧波  Created in 2020/5/8 15:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationEurekaProducer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationEurekaProducer.class, args);
    }


}
