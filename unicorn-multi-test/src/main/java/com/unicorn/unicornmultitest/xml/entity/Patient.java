package com.unicorn.unicornmultitest.xml.entity;

import com.unicorn.unicornmultitest.xml.annoations.CellType;
import com.unicorn.unicornmultitest.xml.annoations.CellTypeEnum;
import lombok.Data;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 15:08:00
 */
@Data
public class Patient {
    /**
     * 病人基本信息
     */

    // 回显
    @CellType(type = CellTypeEnum.SHOW)
    private Long id ;

    // 回显
    @CellType(type = CellTypeEnum.SHOW)
    private String name;

    // 填写
    @CellType(type = CellTypeEnum.FILL)
    private int age;

    // 字典项，翻译用
    @CellType(type = CellTypeEnum.DICT)
    private int sex;

}
