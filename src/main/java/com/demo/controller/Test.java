package com.demo.controller;

import com.demo.model.TeacherStudent;
import com.demo.service.TeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiHaitao
 * @description Test:
 * @date 2019/12/4 14:32
 **/
@RestController
@RequestMapping
public class Test {


    @Autowired
    private TeacherStudentService service;

    @RequestMapping("/test")
    public List<TeacherStudent> createData() {
        return service.getAll();
    }
}
