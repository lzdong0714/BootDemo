package com.unicorn.unicornmultitest.chain.web;

import com.unicorn.unicornmultitest.chain.enumm.Index;
import com.unicorn.unicornmultitest.chain.service.Impl.ProcessServiceA;
import com.unicorn.unicornmultitest.chain.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ModelService modelService;


    @RequestMapping("/index")
    public String init(int index){
        if(index < 0 || index > Index.values().length) throw new IllegalArgumentException("index is not below zero or above size");
        List<String> list = Arrays.asList("a", "b", "c");
        String retStr = modelService.modelInit(index, list);
        return retStr;
    }


    @Autowired
    ProcessServiceA processServiceA;

    @RequestMapping("")
    public String init2(int tagId){
        List<String> list = Arrays.asList("a", "b", "c");
        int initModel = modelService.autoChain(tagId).getInitModel();
        int index = 1;
        return processServiceA.initService(initModel).init(index, list);

    }
}
