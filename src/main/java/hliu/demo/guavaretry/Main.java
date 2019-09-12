package hliu.demo.guavaretry;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;

import java.util.concurrent.TimeUnit;

/**
 * @author LiHaitao
 * @description Main:
 * @date 2019/8/6 11:02
 **/
public class Main {

    public static void main(String[] args) {
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder().
                //如果异常会重试
                        retryIfException().
                //如果结果为false会重试
                        retryIfResult(Predicates.equalTo(false)).
                //重调策略
                        withWaitStrategy(WaitStrategies.fixedWait(3, TimeUnit.SECONDS)).
                //尝试次数
                        withStopStrategy(StopStrategies.stopAfterAttempt(3)).
                //注册监听
                        withRetryListener(new MyRetryListener()).build();
        try {
            Boolean call = retryer.call(new MyCallable());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
