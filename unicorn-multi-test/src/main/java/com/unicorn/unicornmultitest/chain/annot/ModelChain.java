package com.unicorn.unicornmultitest.chain.annot;

import com.unicorn.unicornmultitest.chain.enumm.Index;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月23日 15:15:00
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelChain {
    Index index();

}
