package com.honghu.first_boot.controler;

import com.honghu.first_boot.Service.GirlSevice;
import com.honghu.first_boot.entity.Girl;
import com.honghu.first_boot.repo.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlSevice girlSevice;

    @GetMapping("/girls")
    public List<Girl> girlList(){
        return  girlRepository.findAll();
    }

    @GetMapping("/girl_add")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
       return girlRepository.save(girl);
    }

    @GetMapping("/getGirl/{id}")
    public Girl queryGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    @GetMapping("/girlUpdate/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @GetMapping("/deleteGirl/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    @GetMapping("/queryGirls/{age}")
    public List<Girl> queryGirlsByAge(@PathVariable("age") Integer age){
        return  girlRepository.findGirlsByAge(age);
    }

    @GetMapping("/insertGirls")
    public void insertGirls(){
        girlSevice.InsertTwo();
    }


}
