package com.angsivip.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: 尹碧波  Created in 2020/5/8 15:59
 */
@SpringBootApplication
public class ApplicationEurekaConsumer {


   /* @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/

   // Spring Cloud Ribbon
   @LoadBalanced
   @Bean
   public RestTemplate restTemplate() {
       return new RestTemplate();
   }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEurekaConsumer.class, args);
    }


}
