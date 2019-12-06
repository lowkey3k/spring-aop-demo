package com.demo.controller;

import com.demo.aop.DimensionPadding;
import com.demo.aop.DimensionPaddingList;
import com.demo.model.TeacherStudentVO;
import com.demo.service.StudentService;
import com.demo.service.TeacherService;
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
    @DimensionPaddingList({
            @DimensionPadding(field = "studentsId", fieldAs = "id", name = "studentName", nameAs = "name", service = StudentService.class)
            ,
            @DimensionPadding(field = "studentTeacherId", fieldAs = "id", name = "teacherName", nameAs = "name", service = TeacherService.class)
            ,
            @DimensionPadding(field = "studentsId", fieldAs = "id", name = "studentAge", nameAs = "age", service = StudentService.class)
            ,
            @DimensionPadding(field = "studentTeacherId", fieldAs = "id", name = "teacherAge", nameAs = "age", service = TeacherService.class)
    }
    )
    public List<TeacherStudentVO> createData() {
        return service.getAll();
    }
}
