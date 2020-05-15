package com.angsi.message.mq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ProduceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduceApplication.class, args);
	}

}
