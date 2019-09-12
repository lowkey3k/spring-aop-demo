package hliu.demo.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author LiHaitao
 * @description Main:
 * @date 2019/8/19 15:13
 **/
public class Main {
    public static void main(String[] args) {
       /* String str1 = "abc";
        String str2 = new String("abc");
        String str3 = str2.intern();
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str1 == str3);
*/
        Iterator iterable = new ArrayList().iterator();
        iterable.next();


        List<String> list = new ArrayList();
        list.add("sss");
        list.add("aaa");
        for (String each : list) {
            list.remove(1);
        }

    }
}
