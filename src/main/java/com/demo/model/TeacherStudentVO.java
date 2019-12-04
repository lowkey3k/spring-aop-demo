package com.demo.model;

import lombok.Data;

@Data
public class TeacherStudentVO {


    private Long studentTeacherId;

    private Long studentsId;

    private String studentName;

    private Integer studentAge;

    private String teacherName;

    private Integer teacherAge;

}
