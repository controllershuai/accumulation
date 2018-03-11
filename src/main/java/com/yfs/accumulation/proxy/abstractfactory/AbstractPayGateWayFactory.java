package com.yfs.accumulation.proxy.abstractfactory;

import com.yfs.accumulation.proxy.beans.AliPayGateway;
import com.yfs.accumulation.proxy.beans.PayGateWay;
import com.yfs.accumulation.proxy.beans.PayGateWayType;
import com.yfs.accumulation.proxy.beans.WeChatPayGateway;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPayGateWayFactory {
    private static Map<PayGateWayType, PayGateWay> allPayGateWays = new HashMap<>();

    private void init(){
        try {
            PayGateWay aliPayGateWay = getPayGateWayProxy(new AliPayGateway());
            System.out.println(" init alipay obj success");
            PayGateWay weChatPayGateWay = getPayGateWayProxy(new WeChatPayGateway());
            System.out.println("init wechatpay obj success ");
            allPayGateWays.put(PayGateWayType.Alipay, aliPayGateWay);
            allPayGateWays.put(PayGateWayType.WeCaht, weChatPayGateWay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public PayGateWay getPayGateWay(PayGateWayType gateWayType) {
        if (allPayGateWays.isEmpty()) {
            init();
        }
        return allPayGateWays.get(gateWayType);
    }

    protected abstract PayGateWay getPayGateWayProxy(PayGateWay payGateWay)  throws Exception;
}
