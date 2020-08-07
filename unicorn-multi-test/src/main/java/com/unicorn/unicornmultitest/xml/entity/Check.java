package com.unicorn.unicornmultitest.xml.entity;

import com.unicorn.unicornmultitest.xml.annoations.CellType;
import com.unicorn.unicornmultitest.xml.annoations.CellTypeEnum;
import lombok.Data;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 15:11:00
 */
@Data
public class Check {
    /**
     * 检测项目
     */
    @CellType(type = CellTypeEnum.SHOW)
    private Integer id;

    @CellType(type = CellTypeEnum.DICT)
    private Integer checkType;
    @CellType(type = CellTypeEnum.SHOW)
    private String checkName;

    @CellType(type = CellTypeEnum.SHOW)
    private Float price;

    @CellType(type = CellTypeEnum.FILL)
    private int quantity;
}
