package com.demo.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author LiHaitao
 * @description TransactionUserService:
 * @date 2020/5/26 16:50
 **/
@Service
public class TransactionUserService {


    @Autowired
    private TransactionManagers transactionManagers;


    public void testTransaction(Long deleteId, Long addId) {
        Connection connection = transactionManagers.getConnection();
        try {
            connection.setAutoCommit(false);

            deleteUser(deleteId);
            insertUser(addId);
            int i = 1 / 0;

            connection.commit();//提交后不能回滚

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }


    public void insertUser(Long id) {
        Connection connection = transactionManagers.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute("insert INTO user(id,username,password) VALUES (" + id + ",'lihaitao','123456')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteUser(Long id) {
        Connection connection = transactionManagers.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute("DELETE from user WHERE id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
