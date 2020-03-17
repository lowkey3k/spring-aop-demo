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
    //        Config config = new Config();
    //        config.setTransportMode(TransportMode.EPOLL);
    //        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
    //        RedissonClient redisson = Redisson.create(config);
    //        return redisson.getLock("lock");
    //    }
}
