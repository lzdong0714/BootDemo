package com.unicorn.unicornmultitest;

import com.unicorn.unicornmultitest.netty.HelloServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class UnicornMultiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnicornMultiTestApplication.class, args);
//        HelloServer helloServer = new HelloServer();
//        helloServer.start(new InetSocketAddress("127.0.0.1", 8088));
    }

}
