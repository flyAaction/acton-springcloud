package com.angsivip.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 监控面板
 * Hystrix Dashboard 共支持三种不同的监控方式：
 *
 * 默认的集群监控：通过 URL：http://turbine-hostname:port/turbine.stream 开启，实现对默认集群的监控。
 * 指定的集群监控：通过 URL：http://turbine-hostname:port/turbine.stream?cluster=[clusterName] 开启，实现对 clusterName 集群的监控。
 * 单体应用的监控： 通过 URL：http://hystrix-app:port/hystrix.stream 开启 ，实现对具体某个服务实例的监控。
 * （现在这里的 URL 应该为 http://hystrix-app:port/actuator/hystrix.stream，
 * Actuator 2.x 以后  endpoints 全部在 /actuator 下，可以通过 management.endpoints.web.base-path 修改）
 *
 * @author: 尹碧波  Created in 2020/5/8 17:11
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableHystrix  //@EnableCircuitBreaker 或 @EnableHystrix 注解，开启断路器功能。
public class HystrixDashboardApplication {

    // 浏览器输入 http://localhost:8766/hystrix

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }

}
