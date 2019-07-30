package hliu.demo.aop;

import hliu.demo.model.Log;
import hliu.demo.util.AopUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/7/26.
 */

@Component
public class AopLogService extends StaticMethodMatcherPointcutAdvisor implements ApplicationEventPublisherAware {


    private ApplicationEventPublisher applicationEventPublisher;


    public static final ParameterNameDiscoverer NAME_DISCOVERER = new LocalVariableTableParameterNameDiscoverer();

    public AopLogService() {
        this.setAdvice((MethodInterceptor) (methodInvocation) -> {
            Object proceed;
            Log log = this.createLog(methodInvocation);
            try {
                proceed = methodInvocation.proceed();
                /**
                 *
                 */
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
        String descrption = methodAnnotation.descrption();
        Log log = new Log();
        log.setDescp(descrption);
        log.setMethod(method.getName());
        Object[] arguments = invocation.getArguments();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();
       /* StringBuffer stringBuffer=new StringBuffer();
        Arrays.stream(arguments).forEach(param->{
            stringBuffer.append(param+"|");
        });
        log.setParams(String.valueOf(stringBuffer));*/
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
