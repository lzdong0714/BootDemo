package com.unicorn.unicornmultitest.xml.definition.value;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 17:27:00
 */
public class SimpleValue implements Value{
    private String value;
    public SimpleValue(String value) {
        this.value=value;
    }

    @Override
    public ValueType getType() {
        return ValueType.simple;
    }

    @Override
    public String getValue() {
        return value;
    }
}
