package com.unicorn.unicornmultitest.xml.definition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unicorn.unicornmultitest.xml.definition.value.DataValue;
import com.unicorn.unicornmultitest.xml.definition.value.Value;
import lombok.Data;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 16:44:00
 */
@Data
public class CellDefinition implements Serializable {
    private static final long serialVersionUID = -2667510071560936139L;
    private int rowNumber;
    private int columnNumber;
    private int rowSpan;
    private int colSpan;
    private String name;
    private Value value;
    private DataValue dataValue; // mod by lzd dataValue
    private CellStyle cellStyle=new CellStyle();

    private String linkUrl;
    private String linkTargetWindow;
    private List<LinkParameter> linkParameters;



    private boolean fillBlankRows;
    /**
     * 允许填充空白行时fillBlankRows=true，要求当前数据行数必须是multiple定义的行数的倍数，否则就补充空白行
     */
    private int multiple;

    private Expand expand=Expand.None;
}
