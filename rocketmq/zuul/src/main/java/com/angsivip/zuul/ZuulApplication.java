package com.angsivip.zuul;

import com.angsivip.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author: 尹碧波  Created in 2020/5/11 16:26
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    // 访问 http://localhost:8768/eureka-conusmer/helloFeign?name=222 就可以路由到


    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }


    //使过滤器 生效
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

}
