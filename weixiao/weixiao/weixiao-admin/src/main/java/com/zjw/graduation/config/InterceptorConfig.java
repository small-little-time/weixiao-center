//package com.zjw.graduation.config;
//
//import com.zjw.graduation.interceptor.TokenInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/adm/login");
//    }
//}
