package hliu.demo.highConcurrency;

/**
 * @author LiHaitao
 * @description JoinTest:
 * @date 2019/10/11 11:00
 **/
public class JoinTest {

    public static int a = 0;


    public static void main(String[] args) throws InterruptedException {
        //        noJoin();
        //        joinNoParam();
        joinParam();
    }


    /**
     * join方法，把指定线程加入到当前线程，并且当指定线程执行完才继续执行当前线程。
     *  例如。thread1，thread2。在thread2中thread1.join（），那么thread1执行完，thread2再继续执行。
     */


    /**
     * join()方法;
     * 源码：public final void join() throws InterruptedException {
     * join(0);
     * }
     * <p>
     * 当
     */

    public static void noJoin() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    a += 1;
                }

            }
        });
        thread.start();
        System.out.println("a=" + a);
    }


    public static void joinNoParam() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    a += 1;
                }

            }
        });
        thread.start();
        thread.join();
        System.out.println("a=" + a);
    }

    /**
     * 结果为: a=1000
     */

    /**
     * 如果不加join方法，a=0，是因为main方法结束了线程还在执行。
     * a还是0，但是当加入join方法后，需要等待thread线程执行结束。才会执行main方法后面的输出语句
     */


    /**
     * 重载方法
     * join(long millis)方法，前面介绍的join()方法实际上市join(0)。参数为等待时间，等待多久再执行
     */
    public static void joinParam() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 1000; i++) {
                    a += 1;
                }

            }
        });
        thread.start();
        thread.join(1000);

        System.out.println("a=" + a);
    }

    /**
     * 结果：a=0
     */
    /**
     * 当thread线程执行时休眠2000ms，而join方法只等待1000ms，所以thread线程没有执行结束，a=0；
     */
}
