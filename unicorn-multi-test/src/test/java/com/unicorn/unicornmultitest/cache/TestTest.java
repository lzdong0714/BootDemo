package com.unicorn.unicornmultitest.cache;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestTest {


    @Autowired
    private RestTemplate restTemplate;

    String LOCAL_PORT = "http://localhost:8080";
    @Test
    public void getConnectTest() {
        String url = LOCAL_PORT +  "/cache/test/get";
        String object = restTemplate.getForObject(url, String.class);
        Assert.assertEquals("OK", object);
    }

}