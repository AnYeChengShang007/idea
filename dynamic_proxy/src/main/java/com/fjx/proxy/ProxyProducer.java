package com.fjx.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.rmi.transport.proxy.CGIHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyProducer {
    public static IProducer getProxy(final Producer producer){
        return (IProducer) Proxy.newProxyInstance(Producer.class.getClassLoader(), Producer.class.getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if(method.getName().equals("sale")){
                    Float m = (Float) args[0];
                    method.invoke(producer,m*0.8f);
                }
                return null;
            }
        });
    }

    public static IProducer getProxy2(final Producer producer){
        return (IProducer) Enhancer.create(Producer.class, new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if(method.getName().equals("sale")){
                    Float m = (Float) objects[0];
                    method.invoke(producer,m*0.7f);
                }
                return null;
            }
        });
    }
}
