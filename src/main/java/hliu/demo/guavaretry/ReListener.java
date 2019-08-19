package hliu.demo.guavaretry;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;

/**
 * @author LiHaitao
 * @description ReListener:
 * @date 2019/8/6 11:26
 **/
public class ReListener implements RetryListener {
    @Override
    public <V> void onRetry(Attempt<V> attempt) {

    }
}
