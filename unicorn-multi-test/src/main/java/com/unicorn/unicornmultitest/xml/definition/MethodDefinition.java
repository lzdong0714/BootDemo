package com.unicorn.unicornmultitest.xml.definition;

import lombok.Data;

import java.util.List;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月16日 14:30:00
 */
@Data
public class MethodDefinition {
    private String type;

    private String name;

    private String clazz;

    private List<Parameter> parameterList;

    public static final String typeAttribute = "type";

    public static final String nameAttribute = "name";

    public static final String clazzAttribute = "clazz";
}
