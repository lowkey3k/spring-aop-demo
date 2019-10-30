package com.demo.highConcurrency;

/**
 * @author LiHaitao
 * @description JVMMemoryModel:JVM内存模型基础
 * @date 2019/9/25 14:20
 **/
public class JVMMemoryModel {
    /**
     * 并发编程模型的两个关键问题：
     * 线程之间的通信机制有两种：共享内存和消息传递
     * 同步：同步是指程序中用于控制不同线程间操作发生相对顺序的机制
     * Java的并发采用的是共享内存模型，java线程间的通信总是隐式进行的，整个通信过程对程序员完全透明。
     * Java之间的通信由Java内存模型（JMM）控制，JMM决定一个线程对共享变量的写入何时对另一个线程可见，从抽象角度来看，
     * JMM定义了线程和主内存之间的抽象关系：线程之间的共享变量存储在主内存（Main memory)中，每个线程都有一个私有的本地
     * 内存（Local Memory），本地内存存储了该线程以读写共享变量的副本，本地内存是JMM的一个抽象概念，并不真实存在。它涵盖了
     * 缓存，写缓冲区，寄存器以及其他的硬件和编译器优化。
     */

}
