package com.boot.demo.auth;

public class RequestHolder {
    private static final ThreadLocal<Long> requestHolder = new ThreadLocal<>();
    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long get(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
