package com.unicorn.unicornmultitest.chain.service.Impl;

import com.unicorn.unicornmultitest.chain.service.processService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月23日 11:21:00
 */
@Service
public class processServiceB implements processService {
    @Override
    public String process(int index, List<String> list) {
        if(list == null || list.isEmpty()) return "empty process B";
        if(list.size() < index) return String.format("%02d", index);
        return list.get(index);
    }
}
