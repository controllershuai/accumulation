package com.yfs.accumulation.proxy.abstractfactory;

import com.yfs.accumulation.proxy.beans.PayGateWay;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class CglibPayGateWayPayGateWayFactory extends AbstractPayGateWayFactory {

    @Override
    public  PayGateWay getPayGateWayProxy(PayGateWay payGateWay) throws Exception{
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("method name is " + method.getName());
                System.out.println("before  invoke");
                Object invoke = method.invoke(payGateWay, objects);
                System.out.println("after  invoke");
                return invoke;
            }
        };
        PayGateWay payGateWayProxy = (PayGateWay) Enhancer.create(payGateWay.getClass(), methodInterceptor);
        return payGateWayProxy;
    }
}
