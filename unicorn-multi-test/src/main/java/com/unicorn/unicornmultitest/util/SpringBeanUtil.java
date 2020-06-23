package com.unicorn.unicornmultitest.util;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author: Liu Zhendong
 * @Description 抄一个工具
 * @createTime 2020年06月23日 16:08:00
 */
@Component
public class SpringBeanUtil {

    public static ApplicationContext applicationContext;

    SpringBeanUtil(ApplicationContext context){
        applicationContext = context;
    }

    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

}
