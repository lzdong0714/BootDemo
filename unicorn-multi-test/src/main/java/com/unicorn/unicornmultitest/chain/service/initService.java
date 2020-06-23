package com.unicorn.unicornmultitest.chain.service;

import java.util.List;
import java.util.function.BiFunction;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月23日 11:08:00
 */
@FunctionalInterface
public interface initService
//        extends BiFunction<Integer, List<String>, String>
{

    String init(int index, List<String> listStr);
}
