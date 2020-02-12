package com.fjx.transaction.service.advice;

import com.fjx.transaction.utils.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.annotation.Resource;

public class Transaction {

    @Resource(name="tm")
    TransactionManager tm;

    public void addTransaction(ProceedingJoinPoint pj){
        try {
            tm.begin();
            pj.proceed(pj.getArgs());
            tm.commit();
        } catch (Throwable throwable) {
            tm.rollback();
            throwable.printStackTrace();
        }finally{
            tm.release();
        }
    }
}
