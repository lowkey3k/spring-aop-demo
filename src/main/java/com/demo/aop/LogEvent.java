package com.demo.aop;

import com.demo.model.Log;
import org.springframework.context.ApplicationEvent;

/**
 * @author LiHaitao
 * @description LogEvent:
 * @date 2019/7/30 18:56
 **/
//@Component
public class LogEvent extends ApplicationEvent {


    public LogEvent(Log source) {
        super(source);
    }

    @Override
    public Log getSource() {
        return (Log) super.getSource();
    }
}
