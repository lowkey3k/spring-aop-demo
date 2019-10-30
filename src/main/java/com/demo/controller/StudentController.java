package com.demo.controller;

import com.demo.aop.SystemLogger;
import com.demo.controller.request.NewStudentRequest;
import com.demo.exception.CommonException;
import com.demo.model.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping(path = "/ok")
    @SystemLogger(description = "查询学生")
    public String select() {
        return "ok";
    }


    /*使用consumes限定请求格式为表单格式*/
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @SystemLogger(description = "添加学生")
    public Student addStudentWithoutBindResult(@RequestBody NewStudentRequest newStudent) {
        if (null == newStudent.getName()) {
            throw new CommonException("姓名为空");
        }
        return studentService.saveStudent(newStudent.getName(), newStudent.getAge());
    }

 /*   @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus
    public Student addJsonStudentWithoutBindResult(@Valid @RequestBody NewStudentRequest newStudent) {
        return studentService.saveStudent(newStudent.getName(), newStudent.getAge());
    }*/


    @GetMapping(path = "/getAll")
    @SystemLogger(description = "查询学生")
    @ResponseBody
    public List<Student> getAllStudents() throws Exception {
        return studentService.getAllStudent();
    }

}
