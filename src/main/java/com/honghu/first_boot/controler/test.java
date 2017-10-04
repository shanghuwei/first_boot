package com.honghu.first_boot.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @RequestMapping(value = "/getContent")
    public String getContnent(){
        return "jjjjjjj";
    }
}
