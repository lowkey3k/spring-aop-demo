package com.demo.juc;

/**
 * @author LiHaitao
 * @description UnsafeDemo:
 * @date 2019/9/20 15:50
 **/
public class UnsafeDemo {
    public static void main(String[] args) {
        /**
         *
         Java 不能直接访问操作系统底层，而是通过本地方法来访问。Unsafe 类提供了硬件级别的原子操作。
         Unsafe 类在 sun.misc 包下，不属于 Java 标准。很多 Java 的基础类库，包括一些被广泛使用的高性能开发库都是基于 Unsafe 类开发，
         比如 Netty、Hadoop、Kafka 等。
         Unsafe 是用于在实质上扩展 Java 语言表达能力、便于在更高层（Java 层）代码里实现原本要在更低层（C 层）实现的核心库功能用的。
         这些功能包括裸内存的申请/释放/访问，低层硬件的 atomic/volatile 支持，创建未初始化对象等。
         它原本的设计就只应该被标准库使用，因此不建议在生产环境中使用。
         */
    }
}
