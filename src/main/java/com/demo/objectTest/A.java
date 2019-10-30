package com.demo.objectTest;

/**
 * @author LiHaitao
 * @description A: 接口中的变量默认都是static public final的，1.8开始接口中可以定义static方法。
 * @date 2019/10/14 14:10
 **/
public interface A {

    public static final String a = "sdf";


    public static void get() {
        System.out.println("*****static method*****");
    }

    public static void main(String[] args) {
        A.get();
    }
}
