package com.unicorn.unicornmultitest.xml.parse.impl;

import com.unicorn.unicornmultitest.xml.definition.DataType;
import com.unicorn.unicornmultitest.xml.definition.MethodDefinition;
import com.unicorn.unicornmultitest.xml.definition.Parameter;
import com.unicorn.unicornmultitest.xml.parse.Parser;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月16日 14:39:00
 */
public class MethodParser implements Parser<MethodDefinition> {
    private Map<String, Parser<?>> parsers = new HashMap<>();
//    public  MethodParser(){
//        parsers.put("parameter", new Param)
//    }

    @Override
    public MethodDefinition parse(Element ele) {
        MethodDefinition def = new MethodDefinition();
        def.setType( ele.attributeValue(MethodDefinition.typeAttribute) );
        def.setName( ele.attributeValue(MethodDefinition.nameAttribute) );
        def.setClazz( ele.attributeValue(MethodDefinition.clazzAttribute) );
        def.setParameterList( parseParameters(ele));
        return def;
    }

    private List<Parameter> parseParameters(Element element){
        List<Parameter> parameters=new ArrayList<Parameter>();
        for(Object obj:element.elements()){
            if(obj==null || !(obj instanceof Element)){
                continue;
            }
            Element ele=(Element)obj;
            if(!ele.getName().equals("parameter")){
                continue;
            }
            Parameter param=new Parameter();
            param.setName(ele.attributeValue("name"));
            param.setDefaultValue(ele.attributeValue("default-value"));
            param.setType(DataType.valueOf(ele.attributeValue("type")));
            parameters.add(param);
        }
        return parameters;
    }
}
