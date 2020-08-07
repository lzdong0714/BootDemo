package com.unicorn.unicornmultitest.xml.definition;

import lombok.Data;

import java.awt.*;
import java.io.Serializable;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 16:46:00
 */
@Data
public class CellStyle implements Serializable {
    private static final long serialVersionUID = 8327688051735343849L;
    private String bgcolor;
    private String forecolor;
    private int fontSize;
    private String fontFamily;
    private String format;
    private float lineHeight;
//    private Alignment align;
//    private Alignment valign;
    private Boolean bold;
    private Boolean italic;
    private Boolean underline;
    private Boolean wrapCompute;
//    private Border leftBorder;
//    private Border rightBorder;
//    private Border topBorder;
//    private Border bottomBorder;

    private Font font;
}
