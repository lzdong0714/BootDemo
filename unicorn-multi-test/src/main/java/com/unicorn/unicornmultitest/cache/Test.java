package com.unicorn.unicornmultitest.cache;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Author: Liu Zhendong
 * @Description 连接测试
 * @createTime 2020年06月01日 11:32:00
 */
@RestController
@RequestMapping(value = "/cache/test")
@Slf4j
public class Test {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    BoyServiceImlp boyServiceImlp;


    final String TEST_CACHE = "testCache";
    final String key = "lzd";
    final String val = "fucking world";
    @GetMapping(value = "/get")
    public String getConnectTest(){
        redisTemplate.opsForHash().put(TEST_CACHE , key, val);
        String val =(String) redisTemplate.opsForHash().get(TEST_CACHE, key);
        log.info("{}", val);
        Page<Boy> page = new Page<Boy>(1, 10);
        QueryWrapper<Boy> query = new QueryWrapper<>();
        query.isNotNull("id");
        IPage<Boy> iPage = boyServiceImlp.page(page, query);

        iPage.getRecords().forEach(item->{
            log.info("data : {}",item); }
        );

        return "OK";
    }

    //TODO 用LRU做最近的数据查询，并且从memcache,和redis做缓存更新，与sql做同步

    private void useageOfLRU(){

    }


}
