package hliu.demo.controller;

import hliu.demo.aop.SystemLogger;
import hliu.demo.controller.request.NewStudentRequest;
import hliu.demo.exception.CommonException;
import hliu.demo.model.Student;
import hliu.demo.service.StudentService;
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

    /*使用consumes限定请求格式为表单格式*/
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @SystemLogger(descrption = "添加学生")
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
    @SystemLogger(descrption = "查询学生")
    @ResponseBody
    public List<Student> getAllStudents() throws Exception {
        return studentService.getAllStudent();
    }

    @GetMapping(path = "/ok")
    @SystemLogger(descrption = "查询学生")
    public String select() {
        return "ok";
    }
}
