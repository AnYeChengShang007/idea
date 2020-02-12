package com.fjx.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class ServiceImpl implements IService {
    public void add() {
        System.out.println("add()方法执行了");
    }

    public void update() {
        System.out.println("update方法执行了");
    }

    public int delete(int i) {
        System.out.println("delete方法执行了");
        return 0;
    }

}
