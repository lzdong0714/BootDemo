package com.unicorn.unicornmultitest.xml.definition;

import lombok.Data;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 17:22:00
 */

@Data
public class ConditionCellStyle extends CellStyle{
    private static final long serialVersionUID = -3295823703567508310L;
    private int fontSize;
    private String fontFamily;
    private Scope bgcolorScope=Scope.cell;
    private Scope forecolorScope=Scope.cell;
    private Scope fontSizeScope=Scope.cell;
    private Scope fontFamilyScope=Scope.cell;
    private Scope alignScope=Scope.cell;
    private Scope valignScope=Scope.cell;
    private Scope boldScope=Scope.cell;
    private Scope italicScope=Scope.cell;
    private Scope underlineScope=Scope.cell;
}
