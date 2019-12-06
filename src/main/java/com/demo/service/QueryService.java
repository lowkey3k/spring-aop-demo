package com.demo.service;

/**
 * @author LiHaitao
 * @description QueryService:
 * @date 2019/12/6 11:20
 **/
public interface QueryService<E, PK> {


    E findById(PK id);
}
