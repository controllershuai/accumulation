package com.yfs.accumulation.proxy.factory;

import com.yfs.accumulation.proxy.beans.AliPayGateway;
import com.yfs.accumulation.proxy.beans.PayGateWay;
import com.yfs.accumulation.proxy.beans.PayGateWayType;
import com.yfs.accumulation.proxy.beans.WeChatPayGateway;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class JdkPayGateWayFactory {

    private static  Map<PayGateWayType, PayGateWay> allPayGateWays = new HashMap<>();

    static {
        PayGateWay aliPayGateWay = getPayGateWayProxy(new AliPayGateway());
        System.out.println("init alipay obj success");
        PayGateWay weChatPayGateWay = getPayGateWayProxy(new WeChatPayGateway());
        System.out.println("init wechatpay obj success");
        allPayGateWays.put(PayGateWayType.Alipay, aliPayGateWay);
        allPayGateWays.put(PayGateWayType.WeCaht, weChatPayGateWay);
    }

    public static PayGateWay getPayGateWay(PayGateWayType gateWayType) {
        return allPayGateWays.get(gateWayType);
    }

    public static PayGateWay getPayGateWayProxy(PayGateWay payGateWay){

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("class name :" + proxy.getClass().getName());
                String methodName = method.getName();
                System.out.println("before invoke method!");
                Object invoke = method.invoke(payGateWay, args);
                System.out.println("after invoke method!");
                return invoke;
            }
        };
        PayGateWay payGateWayProxy = (PayGateWay) Proxy.newProxyInstance(
                payGateWay.getClass().getClassLoader(),
                new Class[]{PayGateWay.class},
                invocationHandler);
//        Util.genProxy2file(payGateWay.getClass());
        return payGateWayProxy;
    }
}
