package com.fjx.transaction.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;

@Component("tm")
@Aspect
public class TransactionManager {
    @Resource(name="util")
    private DataSourceUtil util;

    @Pointcut("execution(* com.fjx.transaction.service.*.*(..))")
    public void pt1(){
    }

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

    @Around("pt1()")
    public Object addTransaction(ProceedingJoinPoint jp){
        Object out = null;
        try{
            this.begin();
            out = jp.proceed(jp.getArgs());
            this.commit();
            return out;
        }catch (Throwable e){
            this.rollback();
            throw new RuntimeException(e);
        }finally{
            this.release();
        }
    }

}
