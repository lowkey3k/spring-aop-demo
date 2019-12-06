package com.demo.service;

import cn.hutool.core.util.RandomUtil;
import com.demo.model.Student;
import com.demo.model.Teacher;
import com.demo.model.TeacherStudent;
import com.demo.model.TeacherStudentVO;
import com.demo.repository.StudentTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LiHaitao
 * @description TeacherStudentService:
 * @date 2019/12/4 11:18
 **/
@Service
public class TeacherStudentService implements QueryService<TeacherStudent, Long> {

    @Autowired
    private StudentTeacherRepository repository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    public List<TeacherStudentVO> getAll() {
        List<Student> allStudent = studentService.getAllStudent();
        List<Teacher> teachers = teacherService.getAll();
        teachers.forEach(teacher -> {
            allStudent.forEach(student -> {
                TeacherStudent teacherStudent = new TeacherStudent();
                teacherStudent.setId(RandomUtil.randomLong());
                teacherStudent.setStudentsId(student.getId());
                teacherStudent.setStudentTeacherId(teacher.getId());
                repository.save(teacherStudent);

            });
        });
        List<TeacherStudent> teacherStudents = repository.findAll();
        List<TeacherStudentVO> collect = teacherStudents.stream().map(this::entityToModel).collect(Collectors.toList());
        return collect;
    }


    private TeacherStudentVO entityToModel(TeacherStudent teacherStudent) {
        return new TeacherStudentVO().convertFrom(teacherStudent);
    }

    @Override
    public TeacherStudent findById(Long id) {
        return repository.getOne(id);
    }
}
