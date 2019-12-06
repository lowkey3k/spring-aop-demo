package com.demo.aop;

import java.lang.annotation.*;

/**
 * @author LiHaitao
 * @description DimensionPaddingsList:
 * @date 2019/12/5 18:11
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DimensionPaddingList {
    DimensionPadding[] value();
}
