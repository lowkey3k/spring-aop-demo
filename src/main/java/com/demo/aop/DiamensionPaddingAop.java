package com.demo.aop;

import com.demo.service.QueryService;
import com.demo.util.AopUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */

@Component
public class DiamensionPaddingAop extends StaticMethodMatcherPointcutAdvisor implements ApplicationContextAware {


    private ApplicationContext applicationContext;


    public DiamensionPaddingAop() {
        this.setAdvice((MethodInterceptor) (methodInvocation) -> {

            Object response;

            try {
                response = methodInvocation.proceed();
                if (response == null) {
                    return null;
                }
                Method method = methodInvocation.getMethod();
                Object aThis = methodInvocation.getThis();
                DimensionPaddingList dimensionPaddingList = AopUtil.findMethodAnnotation(aThis.getClass(), method, DimensionPaddingList.class);
                if (dimensionPaddingList != null && dimensionPaddingList.value() != null) {
                    valueComplement(response, Arrays.asList(dimensionPaddingList.value()));
                }

                /* DimensionPaddings 和 DimensionPadding 两个标签是可以共存的 */
                DimensionPadding dimensionPadding = AopUtil.findMethodAnnotation(aThis.getClass(), method, DimensionPadding.class);
                if (dimensionPadding != null) {
                    valueComplement(response, dimensionPadding);
                }


            } catch (Throwable a) {
                throw a;
            }
            return response;
        });
    }

    private void valueComplement(Object response, List<DimensionPadding> dimensionPaddings) {
        dimensionPaddings.forEach(dimensionPadding -> valueComplement(response, dimensionPadding));
    }


    private void valueComplement(Object response, DimensionPadding dimensionPadding) {
        /**
         * 通过field的值作为fieldAs，查找出来后，将nameAs赋值给name
         */
        String field = dimensionPadding.field();//已知值
        String fieldAs = dimensionPadding.fieldAs();//数据源查询条件值，对应已知值
        String name = dimensionPadding.name();//要补全的值
        String nameAs = dimensionPadding.nameAs();//数据源，要对应要补全的值
        Class<?> service = dimensionPadding.service();
        QueryService queryService = (QueryService) applicationContext.getBean(service);
        if (response instanceof Collection) {
            Collection dataList = (Collection) response;
            for (Object data : dataList) {
                Object value = getValue(field, fieldAs, nameAs, queryService, data);
                try {
                    Field declaredField = data.getClass().getDeclaredField(name);
                    declaredField.setAccessible(true);
                    if (value instanceof Number) {
                        declaredField.set(data, (Number) value);
                    }
                    if (value instanceof String) {
                        declaredField.set(data, String.valueOf(value));
                    }
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    private Object getValue(String field, String fieldAs, String nameAs, QueryService queryService, Object data) {
        Field declaredField = null;
        try {
            declaredField = getDeclaredField(data, field);
            assert declaredField != null;
            Object o = declaredField.get(data);
            //这里的查询可以利用fieldAs来进行条件查询。fieldAs=o。但这里用id查询。没有使用到fieldAs
            Object entity = queryService.findById((Long) o);
            Field f = getDeclaredField(entity, nameAs);
            assert f != null;
            return f.get(entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Field getDeclaredField(Object obj, String fieldName) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(fieldName);
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean matches(Method method, Class<?> aClass) {
        DimensionPaddingList dimensionPaddingList = AopUtil.findAnnotation(aClass, method, DimensionPaddingList.class);
        DimensionPadding dimensionPadding = AopUtil.findAnnotation(aClass, method, DimensionPadding.class);
        return dimensionPadding != null || dimensionPaddingList != null;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
