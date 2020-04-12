package com.boot.demo.auth.config;

import com.boot.demo.auth.intercepter.InterceptorTestA;
import com.boot.demo.auth.intercepter.InterceptorTestB;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 执行
            registry.addInterceptor(new InterceptorTestB()).addPathPatterns("/login");
            registry.addInterceptor(new InterceptorTestA()).addPathPatterns("/login");



    }


}
