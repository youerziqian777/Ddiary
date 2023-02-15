package com.springTest.test.controller;

import com.springTest.test.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

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

}
