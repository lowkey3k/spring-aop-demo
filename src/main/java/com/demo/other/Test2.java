package com.demo.other;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LiHaitao
 * @description Test2:
 * @date 2020/4/8 13:04
 **/
public class Test2 {
    public static void main(String[] args) {
        List<Integer> re = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            re.add(i);
        }
        for (int i = 0; i < 15; i++) {
            final List<Integer> collect = re.stream().skip(10 * i).limit(10).collect(Collectors.toList());
            collect.forEach(System.out::print);
            System.out.println("***********************");
        }
    }
}
