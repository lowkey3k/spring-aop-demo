package com.demo.arithmetic;

import lombok.Data;
import lombok.ToString;

/**
 * @author LiHaitao
 * @description Recursion:
 * @date 2019/11/1 16:33
 **/
public class Recursion {
    public static void main(String[] args) {
        System.out.println(jieChen(4));
        System.out.println(fiBonaqi(6));
        System.out.println(tiaotaijie(3));
        Node node = new Node();
        node.val = 1;
        Node node1 = new Node();
        node1.val = 2;
        node.next = node1;
        System.out.println(node);

        //        reverseList(node);
        System.out.println(node.next);
    }


    /**
     * 阶乘
     */
    private static int jieChen(int n) {
        if (n == 1) {
            return 1;
        }
        return jieChen(n - 1) * n;
    }

    /**
     * 斐波那契
     */
    private static int fiBonaqi(int n) {
        if (n <= 2) {
            return n;
        }
        return fiBonaqi(n - 1) + fiBonaqi(n - 2);
    }

    /**
     * 小青蛙条台阶:一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    public static int tiaotaijie(int n) {
        //f(0) = 0,f(1) = 1，f(2) = 2等价于 n<=2时，f(n) = n。
        if (n <= 2) {
            return n;
        }
        return tiaotaijie(n - 1) + tiaotaijie(n - 2);
    }

    @Data
    @ToString
    static class Node {
        Node next;
        int val;

    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node no = reverseList(head.next);
        Node temp = head.next;
        temp.next = head;
        head.next = null;
        return no;
    }
    /**
     * 当m=n时,f(m,n)=n*f(m,n-1);
     当m>n时,f(m,n)=f(m-1,n)+f(m,n-1)；
     当m
     */

}
