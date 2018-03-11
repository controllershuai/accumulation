package com.yfs.accumulation.proxy.abstractfactory;

import com.yfs.accumulation.proxy.beans.PayGateWay;
import com.yfs.accumulation.proxy.beans.PayGateWayType;

public class Test {
    public static void main(String[] args) {
        //这些创建对象最好使用单例，防止对象重复创建
        AbstractPayGateWayFactory jdkFactory = new JdkPayGateWayPayGateWayFactory();
        AbstractPayGateWayFactory ssistFactory = new JavassistPayGateWayPayGateWayFactory();
        AbstractPayGateWayFactory cgLib = new CglibPayGateWayPayGateWayFactory();
        //jdk创建的对象的class不是我们想要的
//        testProxy(jdkFactory);
//        testProxy(ssistFactory);
        testProxy(cgLib);
    }

    public static void testProxy(AbstractPayGateWayFactory factory) {
        PayGateWay aliPay= factory.getPayGateWay(PayGateWayType.Alipay);
        aliPay.pay(555, 123456, 100);
        aliPay.backPay(555, 123456, 100);
        PayGateWay weChatPay= factory.getPayGateWay(PayGateWayType.WeCaht);
        weChatPay.pay(555, 123456, 100);
        weChatPay.backPay(555, 123456, 100);
        System.out.println("=============");
        System.out.println(weChatPay.getClass().getName());
    }

}
