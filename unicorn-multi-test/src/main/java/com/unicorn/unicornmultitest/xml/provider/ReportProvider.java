package com.unicorn.unicornmultitest.xml.provider;

import java.io.InputStream;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月16日 13:40:00
 */
public interface ReportProvider {

    public String fetchType();

    InputStream loadReport(String file);
}
