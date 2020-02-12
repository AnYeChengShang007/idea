package com.fjx.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Bean("runner")
    public QueryRunner getQueryRunner(@Qualifier("ds2") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name="ds1")
    public DataSource getDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setJdbcUrl(url);
            dataSource.setDriverClass(driver);
            dataSource.setUser(user);
            dataSource.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name="ds2")
    public DataSource getDataSource2(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setJdbcUrl(url);
            dataSource.setDriverClass(driver);
            dataSource.setUser(user);
            dataSource.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
