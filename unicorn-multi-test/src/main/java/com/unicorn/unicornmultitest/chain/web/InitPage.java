package com.unicorn.unicornmultitest.chain.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月23日 11:37:00
 */
@RestController //表示restful 的空值类
@RequestMapping("/init") // 空值类下的URL映射
public class InitPage {

    @RequestMapping("")
    public String init(){
        int index = 0;
        List<String> list = Arrays.asList("a", "b", "c");
        return "";
    }
}
