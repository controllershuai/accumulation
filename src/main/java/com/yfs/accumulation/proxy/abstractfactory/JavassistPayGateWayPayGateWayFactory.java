package com.yfs.accumulation.proxy.abstractfactory;

import com.yfs.accumulation.proxy.beans.PayGateWay;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

public class JavassistPayGateWayPayGateWayFactory extends AbstractPayGateWayFactory {

    @Override
    public PayGateWay getPayGateWayProxy(PayGateWay payGateWay) throws Exception {
        ProxyFactory factory = new ProxyFactory();
        System.out.println(payGateWay.getClass().getName());
        factory.setSuperclass(payGateWay.getClass());
        Class aClass = factory.createClass();
        final PayGateWay payGateWayProxy = (PayGateWay) aClass.newInstance();
        MethodHandler methodHandler = new MethodHandler() {
            @Override
            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
                System.out.println("method name  is " + thisMethod.getName());
                System.out.println("before invoke");
                //这里的参数是代理类，别用错了
                Object invoke = proceed.invoke(payGateWayProxy, args);
                System.out.println("after invoke");
                return invoke;
            }
        };
        ((ProxyObject) payGateWayProxy).setHandler(methodHandler);
        return payGateWayProxy;
    }

}
