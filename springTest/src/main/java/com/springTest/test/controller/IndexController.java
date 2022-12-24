package com.springTest.test.controller;

import com.springTest.test.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameIndexController
 * @Description
 * @Author
 * @Date2022/11/7 17:11
 **/
@Configuration
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/test")
    public String test(){
        return indexService.test();
    }
}
