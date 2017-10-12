package com.honghu.first_boot.controler;

import com.honghu.first_boot.Service.GirlSevice;
import com.honghu.first_boot.entity.Girl;
import com.honghu.first_boot.repo.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlSevice girlSevice;

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

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
        Map<String,Object> para = new HashMap<>();
        para.put("id",girl.getId());
        para.put("age",girl.getAge());
        para.put("cupSize" ,girl.getCupSize());
        String sql = "update dbgirl.girl SET age=:age,cup_size=:cupSize WHERE id=:id";

        jdbcTemplate.update(sql,para);
        return girl;
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
