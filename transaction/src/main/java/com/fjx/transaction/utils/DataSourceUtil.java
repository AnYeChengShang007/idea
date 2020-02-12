package com.fjx.transaction.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("util")
public class DataSourceUtil {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Resource(name="dataSource")
    private DataSource ds;

    public Connection getConnection(){
        Connection conn = tl.get();
        if(conn==null){
            try {
                conn = ds.getConnection();
                tl.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void release(){
        tl.remove();
    }
}
