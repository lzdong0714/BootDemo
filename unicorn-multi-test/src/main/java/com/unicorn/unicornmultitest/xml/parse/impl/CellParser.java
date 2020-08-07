package com.unicorn.unicornmultitest.xml.parse.impl;

import com.unicorn.unicornmultitest.xml.definition.CellDefinition;
import com.unicorn.unicornmultitest.xml.definition.CellStyle;
import com.unicorn.unicornmultitest.xml.definition.Expand;
import com.unicorn.unicornmultitest.xml.definition.LinkParameter;
import com.unicorn.unicornmultitest.xml.definition.value.DataValue;
import com.unicorn.unicornmultitest.xml.definition.value.ModelsetValue;
import com.unicorn.unicornmultitest.xml.definition.value.Value;
import com.unicorn.unicornmultitest.xml.exception.ReportParseException;
import com.unicorn.unicornmultitest.xml.parse.Parser;
import org.dom4j.Element;
import org.springframework.expression.common.ExpressionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 16:43:00
 */
public class CellParser implements Parser<CellDefinition> {
        private Map<String,Parser<?>> parsers=new HashMap<String,Parser<?>>();
        public CellParser() {
            parsers.put("simple-value",new SimpleValueParser());
////            parsers.put("image-value",new ImageValueParser());
////            parsers.put("expression-value",new ExpressionValueParser());
////            parsers.put("dataset-value",new DatasetValueParser());
////            parsers.put("slash-value",new SlashValueParser());
////            parsers.put("zxing-value",new ZxingValueParser());
////            parsers.put("chart-value",new ChartValueParser());
            parsers.put("cell-style",new CellStyleParser());
////            parsers.put("link-parameter",new LinkParameterParser());
////            parsers.put("condition-property-item",new ConditionParameterItemParser());
            parsers.put("modelset-value",new ModelsetValueParser());

        }
        @Override
        public CellDefinition parse(Element element) {
            CellDefinition cell=new CellDefinition();
            cell.setName(element.attributeValue("name"));
            cell.setColumnNumber(Integer.valueOf(element.attributeValue("col")));
            cell.setRowNumber(Integer.valueOf(element.attributeValue("row")));
//            cell.setLeftParentCellName(element.attributeValue("left-cell"));
//            cell.setTopParentCellName(element.attributeValue("top-cell"));
            String rowSpan=element.attributeValue("row-span");
            if(!StringUtils.isEmpty(rowSpan)){
                cell.setRowSpan(Integer.valueOf(rowSpan));
            }
            String colSpan=element.attributeValue("col-span");
            if(!StringUtils.isEmpty(colSpan)){
                cell.setColSpan(Integer.valueOf(colSpan));
            }
            String expand=element.attributeValue("expand");
            if(!StringUtils.isEmpty(expand)){
                cell.setExpand(Expand.valueOf(expand));
            }
            String fillBlankRows=element.attributeValue("fill-blank-rows");
            if(!StringUtils.isEmpty(fillBlankRows)){
                cell.setFillBlankRows(Boolean.valueOf(fillBlankRows));
                String multiple=element.attributeValue("multiple");
                if(!StringUtils.isEmpty(multiple)){
                    cell.setMultiple(Integer.valueOf(multiple));
                }
            }
            cell.setLinkTargetWindow(element.attributeValue("link-target-window"));
            String linkUrl=element.attributeValue("link-url");
            cell.setLinkUrl(linkUrl);
            if(!StringUtils.isEmpty(linkUrl)){
//                if(linkUrl.startsWith(ExpressionUtils.EXPR_PREFIX) && linkUrl.endsWith(ExpressionUtils.EXPR_SUFFIX)){
//                    String expr=linkUrl.substring(2,linkUrl.length()-1);
//                    Expression urlExpression=ExpressionUtils.parseExpression(expr);
//                    cell.setLinkUrlExpression(urlExpression);
//                }
            }
            List<LinkParameter> linkParameters=null;
//            List<ConditionPropertyItem> conditionPropertyItems=null;
            for(Object obj:element.elements()){
                if(!(obj instanceof Element)){
                    continue;
                }
                Element ele=(Element)obj;
                Object parseData=parseValue(ele);
                if(parseData instanceof Value){
                    Value value=(Value)parseData;
                    cell.setValue(value);
                }else if(parseData instanceof DataValue){
                    DataValue dataValue = (DataValue) parseData;
                    cell.setDataValue(dataValue);
                }else if(parseData instanceof CellStyle){
                    CellStyle cellStyle=(CellStyle)parseData;
                    cell.setCellStyle(cellStyle);
                }else if(parseData instanceof LinkParameter){
                    if(linkParameters==null){
                        linkParameters=new ArrayList<LinkParameter>();
                    }
                    linkParameters.add((LinkParameter)parseData);
                }
//                else if(parseData instanceof ConditionPropertyItem){
//                    if(conditionPropertyItems==null){
//                        conditionPropertyItems=new ArrayList<ConditionPropertyItem>();
//                    }
//                    conditionPropertyItems.add((ConditionPropertyItem)parseData);
//                }
            }
            if(linkParameters!=null){
                cell.setLinkParameters(linkParameters);
            }
//            cell.setConditionPropertyItems(conditionPropertyItems);
            if(cell.getValue()==null){
                throw new ReportParseException("Cell ["+cell.getName()+"] value not define.");
            }
            return cell;
        }

        private Object parseValue(Element element){
            Parser<?> parser=parsers.get(element.getName());
            if(parser!=null){
                return parser.parse(element);
            }
            throw new ReportParseException("Unknow element :"+element.getName());
        }
}

