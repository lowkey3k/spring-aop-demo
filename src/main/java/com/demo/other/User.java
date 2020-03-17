package com.demo.other;

import lombok.Data;

/**
 * @author LiHaitao
 * @description User:
 * @date 2020/3/17 16:59
 **/
@Data
public class User {
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private Integer age;
}
