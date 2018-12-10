package com.cloud.eurekazuulclient;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Carol on 2018/12/10.
 * MyFilter这个Bean注入IoC容器后，对请求进行了过滤，并在请求路由转发之前进行了逻辑判断。在实际开发中，可以用此过滤器
 * 进行安全验证
 */
@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType(){
        return "pre";
    }

    @Override
    public int filterOrder(){
        return 0;
    }

    @Override
    public boolean shouldFilter(){
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx= RequestContext.getCurrentContext();
        HttpServletRequest request= ctx.getRequest();
        Object accessToken = request.getParameter("token");
        if(accessToken == null){
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("token is empty");
            }catch(Exception e){
                return null;
            }
        }
        log.info("ok");
        return null;
    }


}
