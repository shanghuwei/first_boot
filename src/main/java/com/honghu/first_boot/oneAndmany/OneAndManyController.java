package com.honghu.first_boot.oneAndmany;

import com.honghu.first_boot.Inheritance.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OneAndManyController {
    Logger logger = LoggerFactory.getLogger(OneAndManyController.class);

    @Autowired
    OrderRepo orderRepo;


    @PostMapping("/insert/order")
    public Object InsertPerson(@RequestBody Order order) {
        try {
            orderRepo.save(order);
            Result result = getResult();
            result.setObject(order);
            return new ResponseEntity<Object>(result, HttpStatus.valueOf(result.getCode()));
        } catch (Exception e) {
            logger.error("/insert/order", e.getMessage(), e);
            Result result = new Result();
            result.setCode(400);
            result.setMsg("service error");
            return new ResponseEntity<Object>(result, HttpStatus.valueOf(result.getCode()));
        }
    }



    private Result getResult() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        return result;
    }
}
