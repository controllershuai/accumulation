package com.yfs.accumulation.proxy.factory;

import com.yfs.accumulation.proxy.beans.AliPayGateway;
import com.yfs.accumulation.proxy.beans.PayGateWay;
import com.yfs.accumulation.proxy.beans.PayGateWayType;
import com.yfs.accumulation.proxy.beans.WeChatPayGateway;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CglibPayGateWayFactory {
    private static Map<PayGateWayType, PayGateWay> allPayGateWays = new HashMap<>();

    static {
        try {
            PayGateWay aliPayGateWay = getPayGateWayProxy(new AliPayGateway());
            System.out.println("init alipay obj success");
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
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("method name is " + method.getName());
                System.out.println("before invoke");
                Object invoke = method.invoke(payGateWay, objects);
                System.out.println("after  invoke");
                return invoke;
            }
        };
        PayGateWay payGateWayProxy = (PayGateWay) Enhancer.create(payGateWay.getClass(), methodInterceptor);
        return payGateWayProxy;
    }
}
