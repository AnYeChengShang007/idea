package com.fjx;

import com.fjx.proxy.IProducer;
import com.fjx.proxy.Producer;
import com.fjx.proxy.ProxyProducer;

public class Demo {

    public static void main(String[] args) {
        Producer p = new Producer();
        p.producer();
        p.sale(25f);

        IProducer p1 = ProxyProducer.getProxy(p);
        p1.sale(25f);

        Float m = new Float(8f);

        Object o = m*3;

        IProducer p2 = ProxyProducer.getProxy2(p);
        p2.sale(100);
    }


}
