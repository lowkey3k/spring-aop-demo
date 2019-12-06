package com.demo.model;

import cn.hutool.core.bean.BeanUtil;

import java.util.IllegalFormatException;

/**
 * @author LiHaitao
 * @description ConvertTo:
 * @date 2019/12/5 15:33
 **/
public interface ConvertFrom<E> {

    default <VO extends ConvertFrom<E>> VO convertFrom(E source) throws IllegalFormatException {
        if (source == null) {
            return null;
        } else {
            BeanUtil.copyProperties(source, this);
            return (VO) this;
        }
    }
}
