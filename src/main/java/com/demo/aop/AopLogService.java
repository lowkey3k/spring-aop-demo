package com.demo.aop;

import com.demo.controller.request.NewStudentRequest;
import com.demo.model.Log;
import com.demo.util.AopUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/7/26
 */

@Component
public class AopLogService extends StaticMethodMatcherPointcutAdvisor implements ApplicationEventPublisherAware {


    private ApplicationEventPublisher applicationEventPublisher;


    public AopLogService() {
        this.setAdvice((MethodInterceptor) (methodInvocation) -> {
            Object proceed;
            Log log = null;
            try {
                log = this.createLog(methodInvocation);

                proceed = methodInvocation.proceed();
                if (true) {
                    return proceed;
                }
            } catch (Throwable a) {
                throw a;
            } finally {
                this.applicationEventPublisher.publishEvent(new LogEvent(log));
            }
            return proceed;
        });
    }

    private Log createLog(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Object aThis = invocation.getThis();
        SystemLogger methodAnnotation = AopUtil.findMethodAnnotation(aThis.getClass(), method, SystemLogger.class);
        String description = methodAnnotation.description();
        Log log = new Log();
        log.setDescp(description);
        log.setMethod(method.getName());


        Object[] arguments = invocation.getArguments();
        for (Object argument : arguments) {
            if (argument instanceof NewStudentRequest) {
                System.out.println("ok----------------");
            }
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();
        log.setUrl(requestURI);
        return log;

    }


    @Override
    public boolean matches(Method method, Class<?> aClass) {
        SystemLogger annotation = AopUtil.findAnnotation(aClass, method, SystemLogger.class);
        return annotation != null;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
