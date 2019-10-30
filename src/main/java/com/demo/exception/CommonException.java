package com.demo.exception;

/**
 * @author LiHaitao
 * @description CommonException:
 * @date 2019/8/19 14:22
 **/
public class CommonException extends RuntimeException {


    public CommonException(String message) {
        super(message, null, false, false);
    }
}
