package com.unicorn.unicornmultitest.xml.provider;

import com.unicorn.unicornmultitest.xml.entity.EmrVO;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月16日 15:14:00
 */
@Slf4j
public class ProviderDB implements ReportProvider {

    public static final String dataSourceTyoe = DataBaseType.FILE.toString();

    /**
     * user memory cache as SQL database in available test version,
     * then use redis to develop the demo version
     * then user SQL DB to do the persist save
     * then about hadoop hive ...
     */

    /**
        what's the difference of ThreadLocal , concurrentHashMap ,
     *
      */
    private Map<String, EmrVO> dataDB ;

    public EmrVO get(String key){
        if(key == null || key.equals("")) return null;
        return dataDB.get(key);
    }

    public void put(String key, EmrVO value){
//        if( get(key) != null ) dataDB.remove(key)
        dataDB.put(key, value);

    }

    public ProviderDB(){
        dataDB = new ConcurrentHashMap<String, EmrVO>();
    }

    @Override
    public String fetchType() {
        return dataSourceTyoe;
    }

    @Override
    public InputStream loadReport(String file) {
        return null;
    }
}
