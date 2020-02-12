package com.fjx.proxy;

public class Producer implements IProducer{

    public void producer() {
        System.out.println("生产货物");
    }

    public void sale(float money) {
        System.out.println("卖了"+money+"元");
    }
}
