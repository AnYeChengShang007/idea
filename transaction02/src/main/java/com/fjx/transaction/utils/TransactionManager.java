package com.fjx.transaction.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;

@Component("tm")
public class TransactionManager {
    @Resource(name="util")
    private DataSourceUtil util;

    public void begin(){
        try {
            util.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void commit(){
        try {
            util.getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback(){
        try {
            util.getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void release(){
        util.release();
    }

}
