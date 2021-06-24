package com.internship.second.controllers;

import com.internship.second.model.Student;
import com.internship.second.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;



    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public Student save(@RequestBody Student student) {
        log.info("create {}", student);
        student = studentRepository.save(student);
        return student;
    }


}
