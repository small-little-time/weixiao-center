package com.zjw.graduation.config;

import com.zjw.graduation.interceptor.Swagger2Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Swagger拦截器配置
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 11:50:55
 */
@Configuration
public class Swagger2InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private Swagger2Interceptor swagger2Interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(swagger2Interceptor).addPathPatterns("/swagger-ui.html", "/doc.html");
    }
}
