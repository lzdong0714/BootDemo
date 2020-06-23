package com.unicorn.unicornmultitest.chain.service;

import com.unicorn.unicornmultitest.chain.ModelBean;
import com.unicorn.unicornmultitest.chain.service.Impl.processServiceA;
import com.unicorn.unicornmultitest.util.SpringBeanUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月23日 11:28:00
 */
public class ModelService {

    private Map<Integer, ModelBean> map = new ConcurrentHashMap<>();

    private ModelBean bean = new ModelBean();

    public void updateModel(ModelBean modelBean, int tagId){
        map.put(tagId, modelBean);
    }

    public void autoChain(int tagId){
        bean = map.get(tagId);
    }


    public String modelInit(int index, List<String> list){
        // 可以用近似枚举的方法，列举状态，TODO 内存与BD的一致性
        int initModel = bean.getInitModel();
        // 相同的函数集合类获取
        processServiceA bean = SpringBeanUtil.getBean(processServiceA.class);
        // 依据定义的model调用方法
        initService initService = bean.initService(initModel);
        // 用java8函数方法，简化出的函数指针调用
        String retStr = initService.init(index, list);
        return retStr;
    }


    public String modelProcess(){
        return "";

    }



}
