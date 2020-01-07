package com.demo.other;

import cn.hutool.core.lang.Console;
import com.demo.model.Student;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author LiHaitao
 * @description Test1:
 * @date 2019/12/17 9:02
 **/
public class Test1 {
    public static void main(String[] args) {
        List<String> list = null;
        Optional.ofNullable(list).ifPresent(strings -> strings.forEach(s -> System.out.println(s)));
        String str = null;
        Optional.ofNullable(str).ifPresent(s -> s.trim());
        List<Integer> list1 = Lists.newArrayList(2, 4, 7);
        String a = 5 + "";
        Student student = new Student();
        swap(student, 0);
        // a = 10, b = 5;
        Console.log(student.getName());
    }

    public static void swap(Student x, int y) {
        Student student = new Student();
        student.setName("kjh");
        x = student;
    }

    private void function(Function<String, Integer> function, String str) {
        Integer apply = function.apply(str);

    }
}
