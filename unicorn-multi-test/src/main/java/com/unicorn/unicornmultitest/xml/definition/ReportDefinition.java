package com.unicorn.unicornmultitest.xml.definition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;

import java.util.List;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 17:54:00
 */
@Data
public class ReportDefinition {

    private static final long serialVersionUID = 5934291400824773809L;
    private String reportFullName;
//    private Paper paper;
    private CellDefinition rootCell;
//    private HeaderFooterDefinition header;
//    private HeaderFooterDefinition footer;
//    private SearchForm searchForm;
    private List<CellDefinition> cells;
    private List<MethodDefinition> methods;
//    private List<RowDefinition> rows;
//    private List<ColumnDefinition> columns;
//    private List<DatasourceDefinition> datasources;
    private String searchFormXml;
    @JsonIgnore
    private String style;
}
