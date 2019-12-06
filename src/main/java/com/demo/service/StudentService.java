package com.demo.service;


import com.demo.model.Student;
import com.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
@Service
public class StudentService implements QueryService<Student, Long> {
    @Autowired
    private StudentRepository studentRepository;


    /*添加学生*/
    public Student saveStudent(String name, Integer age) {
        Student student = Student.builder().name(name).age(age).build();
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent() {

        return studentRepository.findAll(Sort.by("id"));
    }


    public void retry(int i) throws Exception {
        System.err.println("重试次数");

        if (i <= 0) {
            throw new Exception("失败重试");
        }
        System.err.println("结束了");
    }


    /*按照姓名获取学生*/
    public List<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    /*按照ID查找学生*/
    public Student get(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.getOne(id);
    }
}
