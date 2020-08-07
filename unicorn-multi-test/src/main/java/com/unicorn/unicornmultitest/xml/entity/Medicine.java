package com.unicorn.unicornmultitest.xml.entity;

import com.unicorn.unicornmultitest.xml.annoations.CellType;
import com.unicorn.unicornmultitest.xml.annoations.CellTypeEnum;
import lombok.Data;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 15:12:00
 */
@Data
public class Medicine {
    /**
     *  处方药物
     */

    @CellType(type = CellTypeEnum.SHOW)
    private Integer id;

    @CellType(type = CellTypeEnum.DICT)
    private Integer medType;
    @CellType(type = CellTypeEnum.SHOW)
    private String medName;

    @CellType(type = CellTypeEnum.SHOW)
    private Float price;

    @CellType(type = CellTypeEnum.FILL)
    private int quantity;
}
