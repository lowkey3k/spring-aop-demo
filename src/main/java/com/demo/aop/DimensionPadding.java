package com.demo.aop;

import java.lang.annotation.*;

/**
 * @author LiHaitao
 * @description DimensionPadding:
 * @date 2019/12/5 16:43
 **/

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DimensionPadding {

    /**
     * 维度补全的原始字段, 如人员编号, 设备编号, 支持嵌套对象, 如fieldA.FieldB.FieldC
     *
     * @return
     */
    String field();

    /**
     * 维度补全底层数据源字段. 如果为空, 使用field
     *
     * @return
     */
    String fieldAs() default "";

    /**
     * 需要补全的字段名称, 如人员名称, 设备名称
     *
     * @return
     */
    String name();

    /**
     * 维度补全底层数据源字段. 如果为空, 使用name
     *
     * @return
     */
    String nameAs() default "";

    //    /**
    //     * 补全方式类型.
    //     *
    //     * @return
    //     */
    //    DimensionPaddingEnum serviceType() default DimensionPaddingEnum.DATA_DICT;


    /**
     * 补全方式的service类型，如果serviceType 为DimensionPaddingEnum#SPRINT_BEAN 该service必须继承自QueryParamService;
     *
     * @return
     */
    Class<?> service() default Object.class;


}
