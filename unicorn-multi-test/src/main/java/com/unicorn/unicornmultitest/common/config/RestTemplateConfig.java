package com.unicorn.unicornmultitest.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月01日 10:16:00
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @ConditionalOnMissingBean({ RestOperations.class, RestTemplate.class })
    //Spring Boot的自动配置机制依靠@ConditionalOnMissingBean注解判断是否执行初始化代码，
    // 即如果用户已经创建了bean，则相关的初始化代码不再执行。
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        // return new RestTemplate(factory);

        RestTemplate restTemplate = new RestTemplate(factory);

        // 使用 utf-8 编码集的 conver 替换默认的 conver（默认的 string conver 的编码集为"ISO-8859-1"）
//        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
//        Iterator<HttpMessageConverter<?>> iterator = messageConverters.iterator();
//        while (iterator.hasNext()) {
//            HttpMessageConverter<?> converter = iterator.next();
//            if (converter instanceof StringHttpMessageConverter) {
//                iterator.remove();
//                messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
//            }
//        }
        return restTemplate;
    }

    @Bean
    @ConditionalOnMissingBean({ClientHttpRequestFactory.class})
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(15000);// ms
        factory.setConnectTimeout(15000);// ms
        return factory;
    }
}
