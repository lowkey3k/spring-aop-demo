package hliu.demo.guavaretry;

import java.util.concurrent.Callable;

/**
 * @author LiHaitao
 * @description MyCallable:
 * @date 2019/8/6 11:02
 **/
public class MyCallable implements Callable {
    private static int i = 0;

    @Override
    public Boolean call() throws Exception {
        i++;
        if (i <= 2) {
            throw new Exception("重试次数达:" + i);
        }
        System.out.println("成功");
        return true;
    }
}
