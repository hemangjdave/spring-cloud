package com.techrevolution.microservices.netflixzullapigatewayserver.componenet;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class ZullLogginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        HttpServletRequest httpServletRequest =
                RequestContext.getCurrentContext().getRequest();

        log.info("request-->{} , request uri is:--{}" , httpServletRequest , httpServletRequest.getRequestURI());

        return null;
    }
}
