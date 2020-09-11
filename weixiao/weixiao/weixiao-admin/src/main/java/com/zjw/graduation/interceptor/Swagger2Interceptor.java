package com.zjw.graduation.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Swagger 拦截器
 * @description 用于禁用swagger，当swagger.disabled为true时重定向至${swagger.redirect-uri}
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 11:54:42
 */
@Configuration
//@Component
//@PropertySource(value = "classpath:application-swagger.yml")
public class Swagger2Interceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(Swagger2Interceptor.class);

    @Value("${swagger.disabled}")
    private Boolean disabledSwagger;

    @Value("${swagger.redirect-uri}")
    private String redirectUri;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(!disabledSwagger) return Boolean.TRUE;
        String uri = redirectUri;
        if(uri == null || uri.trim().length() == 0)
            uri = "/";
        try {
            response.sendRedirect(uri);
        } catch (IOException e) {
            logger.error(String.format("Redirect to '%s' for swagger throw an exception : %s", uri, e.getMessage()), e);
        }
        return Boolean.FALSE;
    }
}
