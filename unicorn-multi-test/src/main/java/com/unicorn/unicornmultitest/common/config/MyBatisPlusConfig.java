package com.unicorn.unicornmultitest.common.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月01日 10:12:00
 */

@Configuration
@MapperScan({"com.unicorn.unicornmultitest.cache"})
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 性能分析插件
     *该插件 3.2.0 以上版本移除推荐使用第三方扩展 执行SQL分析打印 功能
     * @return
     */

    /**
     * 乐观锁插件
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}
