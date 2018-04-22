package com.example.testexample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangdingfeng
 * @version 1.0
 * @create 2018-04-19 18:35
 * @Description 描述
 **/
@RestController
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        System.out.println("234234");
        return "123123123123";
    }
}
