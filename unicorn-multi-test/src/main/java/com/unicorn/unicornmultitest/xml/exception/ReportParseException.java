package com.unicorn.unicornmultitest.xml.exception;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月15日 16:52:00
 */
public class ReportParseException extends RuntimeException {
    private static final long serialVersionUID = -8757106306597844487L;
    public ReportParseException(Exception ex) {
        super(ex);
    }
    public ReportParseException(String msg) {
        super(msg);
    }
}
