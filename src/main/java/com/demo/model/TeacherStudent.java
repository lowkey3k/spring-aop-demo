package com.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_TEACHER_STUDENT")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TeacherStudent extends BaseEntity {
    @Column(name = "student_teacher_id")
    private Long studentTeacherId;
    @Column(name = "students_id")
    private Long studentsId;

}
