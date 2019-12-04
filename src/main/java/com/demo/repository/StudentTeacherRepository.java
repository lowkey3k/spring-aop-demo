package com.demo.repository;

import com.demo.model.TeacherStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/7/26.
 */
@Repository
public interface StudentTeacherRepository extends JpaRepository<TeacherStudent, Long> {


}
