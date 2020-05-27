package com.demo.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author LiHaitao
 * @description CommonConfig:
 * @date 2019/8/6 11:17
 **/
@Configuration
public class CommonConfig {

    //
    //    @Bean
    //    @ConditionalOnProperty(prefix = "redission", name = "enable", havingValue = "true", matchIfMissing = true)
    //    public RLock rLock() {
    //        Config Config = new Config();
    //        Config.setTransportMode(TransportMode.EPOLL);
    //        Config.useSingleServer().setAddress("redis://127.0.0.1:6379");
    //        RedissonClient redisson = Redisson.create(Config);
    //        return redisson.getLock("lock");
    //    }
}
