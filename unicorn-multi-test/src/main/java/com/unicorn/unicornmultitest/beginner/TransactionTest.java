package com.unicorn.unicornmultitest.beginner;

import com.unicorn.unicornmultitest.cache.Boy;
import com.unicorn.unicornmultitest.cache.BoyServiceImlp;
import com.unicorn.unicornmultitest.chain.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Liu Zhendong
 * @Description 事务的回退失败复现与修改
 * @createTime 2020年08月25日 09:16:00
 */
@RestController
@RequestMapping("/transaction")
public class TransactionTest {

    @Autowired
    BoyServiceImlp boyServiceImlp;

    @Autowired
    ExceptionService exceptionService;
    @Transactional
    @PostMapping("/boy")
    public String insertBoy(Boy boy){
        boy.setAge(2);
        boy.setName("lp");
        boy.setAdult(true);
        boyServiceImlp.saveOrUpdate(boy);
//        exceptionService.addExceptionMethod("模拟一个异常！");

        return "success";
    }

}
