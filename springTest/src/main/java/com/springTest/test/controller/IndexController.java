package com.springTest.test.controller;

import com.springTest.test.service.IndexService;
import com.springTest.test.service.PostConstructAndPreDestroyTestService;
import com.springTest.test.service.TransactionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private TransactionTestService transactionTestService;

    @Autowired
    private PostConstructAndPreDestroyTestService postConstructAndPreDestroyTestService;

    @GetMapping("/test1")
    public String test1(){
        return indexService.test1();
    }

    @GetMapping("/test2")
    public String test2(){
        return indexService.test2();
    }

    @GetMapping("/test3")
    public String test3(){
        return indexService.test3();
    }

    @GetMapping("/test4")
    public String test4 (){
        return indexService.test4();
    }

    @GetMapping("/test5")
    public String test5 (){
        return indexService.test5();
    }

    @GetMapping("/test6")
    public String test6 (){
        return transactionTestService.getId();
    }

    @GetMapping("/exception")
    public void exception () throws Exception {
        indexService.exception();
    }

    @GetMapping("/jdbcTemplateTest")
    public String jdbcTemplateTest (){
        return indexService.jdbcTemplateTest();
    }

    @GetMapping("/postConstructAndPreDestroyTestService")
    public void postConstructAndPreDestroyTestService (){
        postConstructAndPreDestroyTestService.test();
    }

    @GetMapping("/test7")
    public void test7 (){
        indexService.test7();
    }
}
