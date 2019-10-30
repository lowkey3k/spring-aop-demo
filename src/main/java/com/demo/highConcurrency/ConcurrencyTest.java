package com.demo.highConcurrency;

import java.text.MessageFormat;

/**
 * @author LiHaitao
 * @description ConcurrencyTest:串行和并发执行累加操作的时间
 * @date 2019/9/23 10:41
 **/
public class ConcurrencyTest {

    private static final long count = 100000001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i > count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        //使thread线程执行结束，再执行下面的打印
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println(MessageFormat.format("currency:{0}ms,b={1}", time, b));
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
        /**
         * 100001
         * currency:33ms,b=-100001
         * serial:3ms,b=-100001,a=500005
         * 1000001
         * currency:7ms,b=-1000001
         * serial:7ms,b=-1000001,a=5000005
         * 10000001
         * currency:10ms,b=-10000001
         * serial:17ms,b=-10000001,a=50000005
         * 100000001
         * currency:87ms,b=-100000001
         * serial:149ms,b=-100000001,a=500000005
         * 总结：并发执行不不一定有串行执行快，因为当操作比较好的时候，并行操作会发生线程创建和上下文切换的开销
         *
         * 如何减少上下文切换：
         * 1，无锁并发编程：多线程竞争锁时，会引发上下文切换，所以多线程处理数据时可以用一些办法避免使用锁，如将数据的ID
         * 按Hash算法取模分段，不同的线程处理不同段的数据。
         * 2，CAS算法：Java的Atomic包使用CAS算法来更新数据，而不需要加锁
         * 3，使用最少线程：避免创建不需要的线程，比如任务很少，但是创建了很多线程来处理，这样会造成大量线程处于等待状态。
         * 4，协程：在单线程里实现多任务的调度，并在单线程里维持多个任务间的切换。
         */


    }
}
