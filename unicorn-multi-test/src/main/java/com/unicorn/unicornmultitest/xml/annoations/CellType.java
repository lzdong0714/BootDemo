package com.unicorn.unicornmultitest.xml.annoations;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 15:19:00
 */

public @interface CellType {
    /**
     * 只是做个标记，与实验xml对应，不做解析
     */
    CellTypeEnum type() default CellTypeEnum.SHOW;

    String context() default "";
}
