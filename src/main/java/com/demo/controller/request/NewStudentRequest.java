package com.demo.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrator on 2019/7/26.
 */
@Setter
@Getter
@ToString
public class NewStudentRequest {
    private String name;
    private Integer age;
}
