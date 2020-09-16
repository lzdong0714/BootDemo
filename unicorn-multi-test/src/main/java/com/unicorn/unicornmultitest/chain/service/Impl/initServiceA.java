package com.unicorn.unicornmultitest.chain.service.Impl;

import com.unicorn.unicornmultitest.chain.service.initService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月23日 11:14:00
 */
@Service
public class initServiceA implements initService {

    @Override
    public String init(int index, List<String> listStr) {
        if(listStr == null || listStr.isEmpty()) return "empty init A";
        if(listStr.size() < index) return String.format("%02d", index);
        return listStr.get(index);
    }

//    @Override
    public String apply(Integer integer, List<String> list) {
        return init(integer, list);
    }
}
