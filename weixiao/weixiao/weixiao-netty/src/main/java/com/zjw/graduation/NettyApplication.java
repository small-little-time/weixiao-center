package com.zjw.graduation;

import com.zjw.graduation.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class);
    }

    @Bean
    public SpringUtil getSpringUtil() {
        return new SpringUtil();
    }
}
