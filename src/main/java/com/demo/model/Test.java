package com.demo.model;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LiHaitao
 * @description Test:
 * @date 2019/11/29 10:47
 **/

public class Test extends Student {

    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor t = new ThreadPoolExecutor(2, 2,
                3L, TimeUnit.DAYS, new LinkedBlockingQueue<Runnable>());
        t.submit(new Runnable() {
            @Override
            public void run() {
                getInstance().count();

            }
        });

        t.submit(new Runnable() {
            @Override
            public void run() {
                getInstance().count();

            }
        });

        //
        //        Thread thread = new Thread(() -> {
        //        });
        //        Thread thread2 = new Thread(() -> {
        //            getInstance().count();
        //        });
        //        thread.start();
        //        thread2.start();
        //        thread.join();
        //        thread2.join();
        System.out.println(count);

    }

    static Test test;

    static Test getInstance() {
        if (test == null) {
            synchronized (Test.class) {
                if (test == null) {
                    test = new Test();
                }
            }
        }
        return test;
    }

    private void count() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }


}
