package com.unicorn.unicornmultitest.xml.provider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月16日 15:35:00
 */
public class ProviderFile implements ReportProvider {

    public static final String dataSourceType = DataBaseType.FILE.toString();


    /***
     * 加载xml格式文件，与DB的数据绑定合成 Report
     */
    private String fileStoreDir;
    public ProviderFile(String filePath){
        this.fileStoreDir = filePath;
    }

    @Override
    public String fetchType() {
        return dataSourceType;
    }

    public InputStream loadReport(String file) {
        try {
            String fullPath=fileStoreDir+"/"+file;
            return new FileInputStream(fullPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
