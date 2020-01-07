package com.demo.other;

import lombok.Data;

/**
 * @author LiHaitao
 * @description DepartmentRequest:
 * @date 2019/12/18 9:53
 **/
@Data
public class UserRequest {

    private Integer hasChild;

    private Integer pageNo;

    private Integer pageSize;
}
