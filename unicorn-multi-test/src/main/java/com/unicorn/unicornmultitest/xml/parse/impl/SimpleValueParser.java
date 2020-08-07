package com.unicorn.unicornmultitest.xml.parse.impl;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 17:26:00
 */

import com.unicorn.unicornmultitest.xml.definition.value.SimpleValue;
import com.unicorn.unicornmultitest.xml.definition.value.Value;
import com.unicorn.unicornmultitest.xml.parse.Parser;
import org.dom4j.Element;
public class SimpleValueParser implements Parser<Value> {
    @Override
    public Value parse(Element element) {
        SimpleValue simpleValue=new SimpleValue(element.getText());
        return simpleValue;
    }
}