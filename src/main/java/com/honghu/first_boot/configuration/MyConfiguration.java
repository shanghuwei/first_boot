package com.honghu.first_boot.configuration;

import com.honghu.first_boot.entity.Girl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean(initMethod = "start",destroyMethod = "destroy")
    public Girl initGirl(){
        Girl girl = new Girl();
        girl.setCupSize("R");
        girl.setAge(25);
        System.out.println("girl start");
        return girl;
    }
}
