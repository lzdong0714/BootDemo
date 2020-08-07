package com.unicorn.unicornmultitest.xml.definition;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月16日 14:36:00
 */
public enum DataType {

    Integer,Float,Boolean,String,Date,List;
    public Object parse(Object obj){
        if(obj==null)return null;
        switch(this){
            case Boolean:
                if(obj.toString().equals("")){
                    return null;
                }
                if(obj instanceof Boolean){
                    return (Boolean)obj;
                }else{
                    return java.lang.Boolean.valueOf(obj.toString());
                }
            case Float:
                if(obj.toString().equals("")){
                    return null;
                }
                if(obj instanceof Float){
                    return (Float)obj;
                }else{
                    return toBigDecimal(obj).doubleValue();
                }
            case Integer:
                if(obj.toString().equals("")){
                    return null;
                }
                if(obj instanceof Integer){
                    return (Integer)obj;
                }else{
                    return toBigDecimal(obj).intValue();
                }
            case String:
                if(obj instanceof String){
                    return (String)obj;
                }else{
                    return obj.toString();
                }
            case List:
                if(obj.toString().equals("")){
                    return null;
                }
                if(obj instanceof java.util.List){
                    return (List<?>)obj;
                }else{
                    String[] arrs=obj.toString().split(",");
                    List<String> list=new ArrayList<String>();
                    for(int i=0;i<arrs.length;i++){
                        list.add(arrs[i]);
                    }
                    return list;
                }
            case Date:
                if(obj.toString().equals("")){
                    return null;
                }
                if(obj instanceof java.util.Date){
                    return (Date)obj;
                }else{
                    Date date=null;
                    SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try{
                        date=sd.parse(obj.toString());
                    }catch(ParseException e){
                        sd=new SimpleDateFormat("yyyy-MM-dd");
                        try{
                            date=sd.parse(obj.toString());
                        }catch(ParseException ex){
                            throw new RuntimeException("Date parameter value pattern must be \"yyyy-MM-dd\" or \"yyyy-MM-dd HH:mm:ss\".");
                        }
                    }
                    return date;
                }
        }
        throw new RuntimeException("Unknow parameter type : " + this);
    }

    private static BigDecimal toBigDecimal(Object obj){
        if(obj==null){
            return null;
        }
        if(obj instanceof BigDecimal){
            return (BigDecimal)obj;
        }else if(obj instanceof String){
            if(obj.toString().trim().equals("")){
                return new BigDecimal(0);
            }
            try{
                String str=obj.toString().trim();
                return new BigDecimal(str);
            }catch(Exception ex){
                throw new RuntimeException("Can not convert "+obj+" to BigDecimal.");
            }
        }else if(obj instanceof Number){
            Number n=(Number)obj;
            return new BigDecimal(n.doubleValue());
        }
        throw new RuntimeException("Can not convert "+obj+" to BigDecimal.");
    }
}
