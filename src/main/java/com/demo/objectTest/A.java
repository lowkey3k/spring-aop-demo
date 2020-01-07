package com.demo.objectTest;


import com.demo.model.Student;
import com.demo.model.StudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * @author LiHaitao
 * @description A: 接口中的变量默认都是static public final的，1.8开始接口中可以定义static方法。
 * @date 2019/10/14 14:10
 **/
@Mapper(componentModel = "spring")
public interface A {

    @Mappings({})
    Student modelToEntity(StudentVO studentVO);

    StudentVO covert(Student student);
}
