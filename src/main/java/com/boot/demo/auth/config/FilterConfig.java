package com.boot.demo.auth.config;

import com.boot.demo.auth.filter.FilterTestA;
import com.boot.demo.auth.filter.FilterTestB;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registrationBeanA() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new FilterTestA());
        filterRegistrationBean.addUrlPatterns("/login");
        filterRegistrationBean.setOrder(10);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean registrationBeanB() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new FilterTestB());
        filterRegistrationBean.addUrlPatterns("/login");
        filterRegistrationBean.setOrder(9);
        return filterRegistrationBean;
    }
}
