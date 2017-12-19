package com.honghu.first_boot.Inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InheritanceController {
    Logger logger = LoggerFactory.getLogger(InheritanceController.class);

    @Autowired
    PersonRepo personRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    TeacherRepo teacherRepo;

    @PostMapping("/insert/person")
    public Object InsertPerson(@RequestBody Person person) {
        try {
            personRepo.save(person);
            Result result = getResult();
            result.setObject(person);
            return new ResponseEntity<Object>(result, HttpStatus.valueOf(result.getCode()));
        } catch (Exception e) {
            logger.error("/insert/person", e.getMessage(), e);
            Result result = new Result();
            result.setCode(400);
            result.setMsg("service error");
            return new ResponseEntity<Object>(result, HttpStatus.valueOf(result.getCode()));
        }
    }

    @PostMapping("/insert/student")
    public Object InsertPerson(@RequestBody Student student) {
        try {
            studentRepo.save(student);
            Result result = getResult();
            result.setObject(student);
            return new ResponseEntity<Object>(result, HttpStatus.valueOf(result.getCode()));
        } catch (Exception e) {
            logger.error("/insert/student", e.getMessage(), e);
            Result result = new Result();
            result.setCode(400);
            result.setMsg("service error");
            return new ResponseEntity<Object>(result, HttpStatus.valueOf(result.getCode()));
        }
    }

    @PostMapping("/insert/teacher")
    public Object InsertTeacher(@RequestBody Teacher teacher) {
        try {
            teacherRepo.save(teacher);
            Result result = getResult();
            result.setObject(teacher);
            return new ResponseEntity<Object>(result, HttpStatus.valueOf(result.getCode()));
        } catch (Exception e) {
            logger.error("/insert/teacher", e.getMessage(), e);
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
