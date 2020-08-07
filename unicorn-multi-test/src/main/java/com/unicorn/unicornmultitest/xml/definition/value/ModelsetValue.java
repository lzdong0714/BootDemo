package com.unicorn.unicornmultitest.xml.definition.value;

import lombok.Data;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 16:32:00
 */
@Data
public class ModelsetValue implements DataValue {

    private String modelName; // 数据类名称

    private String fieldName; // 属性名

    private String cellType;// 显示类型

    private String value;
}
