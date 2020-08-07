package com.unicorn.unicornmultitest.xml.export;

import com.unicorn.unicornmultitest.xml.definition.CellDefinition;
import com.unicorn.unicornmultitest.xml.definition.ReportDefinition;
import com.unicorn.unicornmultitest.xml.definition.value.DataValue;
import com.unicorn.unicornmultitest.xml.definition.value.ModelsetValue;
import com.unicorn.unicornmultitest.xml.entity.EmrVO;
import com.unicorn.unicornmultitest.xml.exception.ReportParseException;
import com.unicorn.unicornmultitest.xml.parse.ReportParser;
import com.unicorn.unicornmultitest.xml.provider.DataBaseType;
import com.unicorn.unicornmultitest.xml.provider.ProviderDB;
import com.unicorn.unicornmultitest.xml.provider.ProviderFile;
import com.unicorn.unicornmultitest.xml.provider.ReportProvider;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月16日 13:37:00
 */
public class ReportRender {

    private ReportParser reportParser= new ReportParser();
//    private Collection<ReportProvider> reportProviders = ;
    public String filePath = "D:\\workproject\\ureport2";
    private ProviderDB providerDB = new ProviderDB();
    private ProviderFile providerFile = new ProviderFile(filePath);
    public ReportDefinition parseReport(String file){
        InputStream inputStream=null;
        try {
            inputStream=buildReportFile(file);
            ReportDefinition reportDefinition=reportParser.parse(inputStream,file);
            return reportDefinition;
        }finally{
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new ReportParseException(e);
            }
        }
    }

    private InputStream buildReportFile(String file){
        InputStream inputStream=providerFile.loadReport(file);
        if(inputStream==null){
            throw new RuntimeException("Report ["+file+"] not support.");
        }
        return inputStream;
    }

    private OutputStream merge(String inputFileName, String outputFileName){
        // TODO DB 的 data 与 ReportDefinition 融合在一起，输出一个融合的xml模拟html的输出
        InputStream inputStream=providerFile.loadReport(inputFileName);
        ReportDefinition reportDef  =reportParser.parse(inputStream, inputFileName);
        EmrVO emrVO  = providerDB.get(inputFileName);
        try(
//            FileOutputStream outputStream = new FileOutputStream(file);
            FileOutputStream outputStream = new FileOutputStream( new File(filePath + "\\" + outputFileName));
            ) {
//            File file = new File(filePath + "\\" + outputFileName);
            List<CellDefinition> cells = reportDef.getCells();
            for(CellDefinition cell : cells){
                DataValue dataValue = cell.getDataValue();
                if(dataValue instanceof ModelsetValue){
                    ModelsetValue setValue = (ModelsetValue) dataValue;
                    String modelName = setValue.getModelName();
                    Field[] declaredFields = emrVO.getClass().getDeclaredFields();
                    for(Field field : declaredFields){
                        if(field.getType().getName().equals(modelName)){
//                            field.;
                        }
                    }
                }

            }
            return outputStream;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
