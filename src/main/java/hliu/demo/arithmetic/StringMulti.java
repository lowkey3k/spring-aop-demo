package hliu.demo.arithmetic;

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
        if (now == "") {
            return source;
        }
        String result = "";
        int ten = 0;
        result = source.charAt(source.length() - 1) + result;
        int j = now.length() - 1;
        for (int i = source.length() - 2; i >= 0 && j >= 0; i--, j--) {
            int add = Integer.parseInt(source.charAt(i) + "") + Integer.parseInt(now.charAt(j) + "") + ten;
            ten = add / 10;
            result = add % 10 + result;
        }
        if (j == -1) {
            result = ten + result;
        } else {
            int f = Integer.parseInt(source.charAt(0) + "") + ten;
            result = f + result;

        }
        return result;
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
