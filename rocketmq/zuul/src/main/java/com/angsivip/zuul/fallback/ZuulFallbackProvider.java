package com.angsivip.zuul.fallback;

import org.springframework.http.client.ClientHttpResponse;

/**
 * 路由熔断
 * <p>
 * 当我们的后端服务出现异常的时候，我们不希望将异常抛出给最外层，期望服务可以自动进行一降级。
 * Zuul给我们提供了这样的支持。当某个服务出现异常时，直接返回我们预设的信息。
 * <p>
 * 我们通过自定义的fallback方法，并且将其指定给某个route来实现该route访问出问题的熔断处理。
 * 主要继承ZuulFallbackProvider接口来实现，ZuulFallbackProvider默认有两个方法，一个用来指明熔断拦截哪个服务，一个定制返回内容。
 *
 * @author: 尹碧波  Created in 2020/5/13 15:29
 */
public interface ZuulFallbackProvider {
    /**
     * getRoute方法，告诉Zuul它是负责哪个route定义的熔断
     *
     * @return The route the fallback will be used for.
     */
    public String getRoute();

    /**
     * fallbackResponse方法则是告诉 Zuul 断路出现时，它会提供一个什么返回值来处理请求
     *
     * @return The fallback response.
     */
    public ClientHttpResponse fallbackResponse();


}
