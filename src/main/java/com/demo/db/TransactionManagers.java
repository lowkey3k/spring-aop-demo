package com.demo.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author LiHaitao
 * @description TransactionUserService:
 * @date 2020/5/26 16:50
 **/
@Slf4j
@Component
public class TransactionManagers {


    @Resource
    DataSource dataSource;

    ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public Connection getConnection() {
        if (threadLocal.get() == null) {
            try {
                threadLocal.set(dataSource.getConnection());
                return threadLocal.get();
            } catch (SQLException e) {
                log.info("获取数据库连接失败:{}", e.getMessage());
                return null;
            }
        }
        return threadLocal.get();
    }


}
