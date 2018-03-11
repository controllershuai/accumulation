package com.yfs.accumulation.proxy.abstractfactory;

import com.yfs.accumulation.proxy.beans.PayGateWay;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkPayGateWayPayGateWayFactory extends AbstractPayGateWayFactory {

    @Override
    public PayGateWay getPayGateWayProxy(PayGateWay payGateWay) throws Exception{

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("class name :" + proxy.getClass().getName());
                String methodName = method.getName();
                System.out.println("before invoke  method!");
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
