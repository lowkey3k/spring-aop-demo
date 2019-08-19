package hliu.demo.config;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author LiHaitao
 * @description CommonConfig:
 * @date 2019/8/6 11:17
 **/
@Configuration
public class CommonConfig {


    @Bean
    public Retryer<Boolean> retryer(RetryListener retryListener) {
        return RetryerBuilder.<Boolean>newBuilder().
                //如果异常会重试
                        retryIfException().
                //如果结果为false会重试
                        retryIfResult(Predicates.equalTo(false)).
                //重调策略
                        withWaitStrategy(WaitStrategies.fixedWait(3, TimeUnit.SECONDS)).
                //尝试次数
                        withStopStrategy(StopStrategies.stopAfterAttempt(3)).
                //注册监听
                        withRetryListener(retryListener).build();
    }


}
