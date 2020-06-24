package com.unicorn.unicornmultitest.chain.service.Impl;

import com.unicorn.unicornmultitest.chain.enumm.Index;
import com.unicorn.unicornmultitest.chain.service.initService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiFunction;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月23日 11:18:00
 */
@Service
public class initServiceB implements initService {


    @Override
    public String init(int index, List<String> listStr) {
        if(listStr == null || listStr.isEmpty()) return "empty init B";
        if(listStr.size() < index) return String.format("%02d", index);
        return listStr.get(index);
    }

    public String apply(Integer integer, List<String> list) {

        return init(integer, list);
    }


    public BiFunction<Integer, List<String>, String> getFunction(int index){
        switch (Index.values()[index]){
            case HIDDEN: return this::init;
            case SHOW:   return this::apply;
            default:     return this::init;
        }
    }
}

