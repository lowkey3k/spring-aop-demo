package com.demo.arithmetic;

import java.util.Objects;

/**
 * @author LiHaitao
 * @description StringMulti:
 * @date 2019/9/12 11:20
 **/
public class StringMulti {
    public static void main(String[] args) {
        System.out.println("re:" + multi("123", "456"));
        System.out.println("mal:" + malposition("912", "1368"));
    }

    private static String multi(String a, String b) {
        String result = "";
        String temp = "";
        int ten = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            temp = "";
            ten = 0;
            for (int j = b.length() - 1; j >= 0; j--) {
                int add = Integer.parseInt(a.charAt(i) + "") * Integer.parseInt(b.charAt(j) + "");
                if (ten != 0) {
                    temp = (add + ten) + temp.substring(1, temp.length());
                } else {
                    ten = add / 10;
                    temp = add + temp;
                }
            }
            System.out.println("temp:" + temp + "reslult:" + result);
            result = malposition(temp, result);
            System.out.println("reslult" + result);
        }

        return result;

    }

    private static String malposition(String source, String now) {
        if (Objects.equals(now, "")) {
            return source;
        }
        StringBuilder result = new StringBuilder();
        int ten = 0;
        result.insert(0, source.charAt(source.length() - 1));
        int j = now.length() - 1;
        for (int i = source.length() - 2; i >= 0 && j >= 0; i--, j--) {
            int add = Integer.parseInt(source.charAt(i) + "") + Integer.parseInt(now.charAt(j) + "") + ten;
            ten = add / 10;
            result.insert(0, add % 10);
        }
        if (j == -1) {
            result.insert(0, ten);
        } else {
            int f = Integer.parseInt(source.charAt(0) + "") + ten;
            result.insert(0, f);

        }
        return result.toString();
    }


    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }
        //            System.out.println("ten:" + ten);
        //            System.out.println("i:" + Integer.parseInt(source.charAt(i) + "") + "j:" + Integer.parseInt(now.charAt(j)
        //                    + ""));
        //            System.out.println("add:" + add);

        print(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
