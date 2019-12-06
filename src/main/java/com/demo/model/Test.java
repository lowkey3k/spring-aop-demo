package com.demo.model;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author LiHaitao
 * @description Test:
 * @date 2019/11/29 10:47
 **/

public class Test extends Student {


    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(12);
        student.setName("lihaitao");
        Field[] fields = student.getClass().getDeclaredFields();
        List<Field> fieldArrayList = Lists.newArrayList(fields);
        Object a = 12;
        fieldArrayList.forEach(field -> {
            if (field.getName().equals("age")) {
                try {
                    field.setAccessible(true);
                    field.set(student, (Number) a);
                    Object o = field.get(student);
                    System.out.println(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(field.getName());
        });
        System.out.println(student);
    }
}
