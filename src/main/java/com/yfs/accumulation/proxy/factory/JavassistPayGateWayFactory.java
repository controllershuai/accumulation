package com.yfs.accumulation.proxy.factory;

import com.yfs.accumulation.proxy.beans.AliPayGateway;
import com.yfs.accumulation.proxy.beans.PayGateWay;
import com.yfs.accumulation.proxy.beans.PayGateWayType;
import com.yfs.accumulation.proxy.beans.WeChatPayGateway;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JavassistPayGateWayFactory {

    private static Map<PayGateWayType, PayGateWay> allPayGateWays = new HashMap<>();

    static {
        try {
            PayGateWay aliPayGateWay = getPayGateWayProxy(new AliPayGateway());
            System.out.println("init alipay obj success ");
            PayGateWay weChatPayGateWay = getPayGateWayProxy(new WeChatPayGateway());
            System.out.println("init wechatpay obj success ");
            allPayGateWays.put(PayGateWayType.Alipay, aliPayGateWay);
            allPayGateWays.put(PayGateWayType.WeCaht, weChatPayGateWay);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    public static PayGateWay getPayGateWay(PayGateWayType gateWayType) {
        return allPayGateWays.get(gateWayType);
    }

    public static PayGateWay getPayGateWayProxy(PayGateWay payGateWay) throws IllegalAccessException, InstantiationException {
        ProxyFactory factory = new ProxyFactory();
        System.out.println(payGateWay.getClass().getName());
        factory.setSuperclass(payGateWay.getClass());
        Class aClass = factory.createClass();
        final PayGateWay payGateWayProxy = (PayGateWay) aClass.newInstance();
        MethodHandler methodHandler = new MethodHandler() {
            @Override
            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
                System.out.println("method name is " + thisMethod.getName());
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
