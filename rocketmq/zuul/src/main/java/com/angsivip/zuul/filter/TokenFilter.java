package com.angsivip.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关过滤器
 *  Filter 的生命周期有 4 个，分别是 “PRE”、“ROUTING”、“POST” 和 “ERROR”，
 * <p>
 * filterType()：过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。这里定义为 pre，代表会在请求被路由之前执行。
 * filterOrder()：过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。通过数字指定，数字越大，优先级越低。
 * shouldFilter()：判断该过滤器是否需要被执行。这里我们直接返回了 true，因此该过滤器对所有请求都会生效。实际运用中我们可以利用该函数来指定过滤器的有效范围。
 * run()：过滤器的具体逻辑。这里我们通过 ctx.setSendZuulResponse(false)
 * 令 Zuul 过滤该请求，不对其进行路由，然后通过 ctx.setResponseStatusCode(401) 设置了其返回的错误码，
 * 当然我们也可以进一步优化我们的返回，比如，通过 ctx.setResponseBody(body) 对返回 body 内容进行编辑等。
 *
 * @author: 尹碧波  Created in 2020/5/13 15:10
 */
public class TokenFilter extends ZuulFilter {

    /**
     * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
     * 这里定义为pre，代表会在请求被路由之前执行。
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter执行顺序，通过数字指定。
     * 数字越大，优先级越低。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。
     * 实际运用中我们可以利用该函数来指定过滤器的有效范围。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 过滤器的具体逻辑
     *
     * @return
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (token == null || token.isEmpty()) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token is empty");
        }
        return null;
    }
}
