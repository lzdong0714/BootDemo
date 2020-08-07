package com.unicorn.unicornmultitest.xml.definition;

import lombok.Data;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月16日 14:35:00
 */
@Data
public class Parameter {

    private String name;
    private DataType type;
    private String defaultValue;
}
