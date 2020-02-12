package com.fjx.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {

    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }

    public void afterReturning(){
        System.out.println("afterReturning");
    }

    public void afterThrowing(){
        System.out.println("afterThrowing");
    }

    public Object testArroundAdvice(ProceedingJoinPoint jp){
        Object o = null;
        try {
            System.out.println("前置通知");
            o = jp.proceed(jp.getArgs());
            System.out.println("后置通知");
            return o;
        } catch (Throwable e) {
            System.out.println("异常通知");
            return new RuntimeException(e);
        }finally{
            System.out.println("最终通知");
        }
    }
}
