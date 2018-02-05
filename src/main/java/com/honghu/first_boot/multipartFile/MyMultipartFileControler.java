package com.honghu.first_boot.multipartFile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class MyMultipartFileControler {
    @PostMapping(value = "/upload")
    public String upLoad(@RequestParam("test") MultipartFile file){
        try {
            file.transferTo(new File("E://File//" + file.getOriginalFilename()));
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
