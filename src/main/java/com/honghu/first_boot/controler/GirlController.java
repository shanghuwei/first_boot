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

    @PostMapping("/girl_add")
    public Girl girlAdd(@RequestBody Girl girl) {
        return girlRepository.save(girl);
    }

    @GetMapping("/getGirls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    @GetMapping("/getGirl/{id}")
    public Girl queryGirl(@PathVariable Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping("/girlUpdate")
    public Girl updateGirl(@RequestBody Girl girl) {

        return girlRepository.save(girl);
    }

    @DeleteMapping("/deleteGirl/{id}")
    public String deleteGirl(@PathVariable Integer id) {
        girlRepository.delete(id);
        return "delete success id = " + id;
    }

    @GetMapping("/queryGirls")
    public List<Girl> queryGirlsByAge(@RequestParam Integer age) {
        return girlRepository.findGirlsByAge(age);
    }

    @GetMapping("/insertGirls")
    public void insertGirls() {
        girlSevice.InsertTwo();
    }


}
