package com.unicorn.unicornmultitest.xml.entity;

import com.unicorn.unicornmultitest.xml.annoations.CellType;
import com.unicorn.unicornmultitest.xml.annoations.CellTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 15:08:00
 */
@Data
@CellType(type = CellTypeEnum.COMPLEX)
public class EmrVO {

    private Patient patient;

//    private List<Check> checks;
//
//    private List<Medicine> medicines;

    private Medicine medicine;

    private Check check;


}
