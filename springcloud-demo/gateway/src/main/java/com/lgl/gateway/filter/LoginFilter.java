package com.lgl.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lgl
 * @Description: 网关的登录验证demo
 * @date 2019/12/29 7:04 下午
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 拦截的类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 拦截优先级
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * 要不要过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //1.获取请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //2.获取request
        HttpServletRequest request = ctx.getRequest();
        //3.获取请求参数access-token
        String token = request.getParameter("access-token");
        //4.判断是否存在
        if (StringUtils.isBlank(token)) {
            //5.不存在,未登录,则拦截
            ctx.setSendZuulResponse(false);
            //返回403
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }

        return null;
    }
}
