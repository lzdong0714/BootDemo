package com.unicorn.unicornmultitest.xml.parse;

import org.dom4j.Element;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 15:59:00
 */
public interface Parser<T> {
    T parse(Element element);
}
