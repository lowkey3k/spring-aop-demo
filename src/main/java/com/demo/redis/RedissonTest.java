package com.demo.redis;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

/**
 * @author LiHaitao
 * @description RedissonTest:
 * @date 2019/12/11 16:51
 **/
public class RedissonTest {


    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);
        RedissonReactiveClient reactive = Redisson.createReactive(config);
        RMap<String, String> map = redisson.getMap("myMap");
        RAtomicLong myLong = redisson.getAtomicLong("myLong");
        myLong.compareAndSet(2, 100);
        RFuture<Boolean> booleanRFuture = myLong.compareAndSetAsync(2, 100);
        //        for (; ; ) {
        long l = myLong.incrementAndGet();
        System.out.println(l);

        //        }

    }


}
