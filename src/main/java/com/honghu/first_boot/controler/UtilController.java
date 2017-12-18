package com.honghu.first_boot.controler;

import com.honghu.first_boot.util.MyEnum;
import com.honghu.first_boot.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class UtilController {

    Logger logger = LoggerFactory.getLogger(UtilController.class);

    @GetMapping("/enum")
    public Object enumText() {
        try {
            for (MyEnum e : MyEnum.values()) {
                logger.error(e.toString());
            }
            MyEnum myEnum = MyEnum.B;
            switch (myEnum) {
                case A:
                    logger.error("aaaaaaa");
                    break;
                case B:
                    logger.error("bbbbbbbb");
                    break;
                default:
                    System.out.println(myEnum);
                    break;
            }
            return null;
        } catch (Exception e) {
            logger.error(e.toString(),e.getMessage());
            Result result = new Result();
            result.setCode(400);
            result.setMsg("error");
            return new ResponseEntity<>(result, HttpStatus.valueOf(result.getCode()));
        }
    }
}
