package com.demo.aop;

import com.demo.repository.SystemLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author LiHaitao
 * @description LogListener:
 * @date 2019/7/30 18:59
 **/
@Slf4j
@Component
public class LogListener implements ApplicationListener<LogEvent> {

    @Autowired
    private SystemLogRepository systemLogRepository;


    @Override
    @Async
    public void onApplicationEvent(LogEvent logEvent) {
        systemLogRepository.save(logEvent.getSource());
        log.info("添加成功：");
    }
}
