package hliu.demo.guavaretry;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;

/**
 * @author LiHaitao
 * @description MyRetryListener:
 * @date 2019/8/6 11:00
 **/
public class MyRetryListener implements RetryListener {

    @Override
    public <V> void onRetry(Attempt<V> attempt) {
        System.out.print("[retry]time=" + attempt.getAttemptNumber());
        // 距离第一次重试的延迟
        System.out.print(",delay=" + attempt.getDelaySinceFirstAttempt());

        // 重试结果: 是异常终止, 还是正常返回
        System.out.print(",hasException=" + attempt.hasException());
        System.out.print(",hasResult=" + attempt.hasResult());

        // 是什么原因导致异常
        if (attempt.hasException()) {
            System.out.print(",causeBy=" + attempt.getExceptionCause().toString());
        } else {
            // 正常返回时的结果
            System.out.print(",result=" + attempt.getResult());
        }
        System.out.println();

    }
}
