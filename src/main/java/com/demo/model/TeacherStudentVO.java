package com.demo.model;

import lombok.Data;

@Data
public class TeacherStudentVO extends BaseVO<TeacherStudent> {


    private Long studentTeacherId;

    private Long studentsId;

    private String studentName;

    private Integer studentAge;

    private String teacherName;

    private Integer teacherAge;


}
