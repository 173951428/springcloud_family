package com.springcloud.springcloud_gateway.filter;

import com.google.common.collect.Sets;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;


/**
 * zuul 登录过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {


    //排除过滤的 uri 地址
    Set<String> urls = Sets.newHashSet("/apigateway/order/api/v1/order/save");
    /**
     * 过滤器类型，前置过滤器
     *
     * @return
     */
    @Override
    public String filterType() {
        //表示是一个前置过滤器类型
        return "pre";
    }

    // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    @Override
    public int filterOrder() {
        return 0;
    }

    // 表示过滤器是否生效，默认为fasle，现在配置为true，
    @Override
    public boolean shouldFilter() {
        // 获取当前请求的上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String url=request.getRequestURI();
        System.out.println(url);
        if(urls.contains(url)){
            return true;
        }

        return false;
    }

    /**
     * 拦截以后做的事情
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("请求的url被拦截了");

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token=request.getHeader("token");
        if(StringUtils.isBlank(token)){
            token=request.getParameter("token");
        }
        // 登录校验逻辑，根据公司情况自定义，比如根据一个加密算法，用户登录的时候，返回一个token，以后每个请求都获取这个token，进行解密校验操作
        if(StringUtils.isBlank(token)){
            requestContext.setSendZuulResponse(false); // 设置zull返回状态错误
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);// 返回401
        }

        return null;
    }
}
