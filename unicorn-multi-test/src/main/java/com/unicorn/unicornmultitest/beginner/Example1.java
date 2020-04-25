package com.unicorn.unicornmultitest.beginner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Author: Liu Zhendong
 escription 第一个示例
 * @createTime 2020年04月25日 09:37:00
 */

@RestController //表示restful 的空值类
@RequestMapping("/ep-1") // 空值类下的URL映射
public class Example1 {

    @RequestMapping("/1") //         postman url = http://localhost:8080/ep-1/1
    public String getString(){
        return "hello world !";
    }

    @RequestMapping("/2") //返回数据实体 postman url = http://localhost:8080/ep-1/2
    public ReturnData getDataInputNone(){
        return new ReturnData();
    }

    @RequestMapping("/3") //            postman url http://localhost:8080/ep-1/3?name=cf
    // 这里的前端输入字符串如何提交我就不懂了
    // postman中 url =
    public ReturnData getDateWithInput(@RequestParam String name){
        ReturnData ret = new ReturnData();
        ret.name = name + ret.name; // 模拟输入，改变输出， 这里实际就是再去查SQL，写一些逻辑；
        return ret;
    }


}

// 一个有组成的数据,即所谓的json对象
class ReturnData{
    public String  name     = "xyz";
    public long    number   = 100L;
    public LocalDateTime time = LocalDateTime.now();

}
