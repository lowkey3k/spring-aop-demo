package com.demo.collections;

import java.util.Scanner;

/**
 * @author LiHaitao
 * @description BTree:
 * @date 2019/10/21 14:57
 **/
public class BTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入学生成绩：");
        double grade = in.nextDouble();
        if (grade >= 0 && grade <= 100) {
            System.out.println("有效成绩");
        } else {
            System.out.println("无效成绩");
        }
    }
}
