package com.fjx.transaction.factory;

import com.fjx.transaction.demo.Account;
import com.fjx.transaction.service.IUserService;
import com.fjx.transaction.service.UserService;
import com.fjx.transaction.utils.TransactionManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component("factory")
public class beanFactory {

    @Resource(name="accountService")
    private IUserService service;
    @Resource(name="tm")
    private TransactionManager tm;


    public IUserService getServiceProxy(){
        return (IUserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),UserService.class.getInterfaces(),new InvocationHandler(){
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("transfer")){
                    try {
                        tm.begin();
                        method.invoke(service,args);
                        tm.commit();
                    } catch (Exception e) {
                        tm.rollback();
                        throw new RuntimeException(e);
                    }
                }
                return null;
            }
        });
    }
}
