package com.springTest.test.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description lilicat
 * @Date 2023/3/4 18:15
 **/
@Configuration
@RestController
public class ChatGptController {
    @PostMapping("/chatgptDemo")
    public void chatgptDemo(){
        //return indexService.test1();
    }
}
