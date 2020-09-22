package com.unicorn.unicornmultitest.chain.service;

import com.unicorn.unicornmultitest.beginner.ControllerException;
import org.springframework.stereotype.Service;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年08月25日 09:44:00
 */
@Service
public class ExceptionService {

    public void addExceptionMethod(String msg){

        throw new ControllerException(msg);
    }
}
