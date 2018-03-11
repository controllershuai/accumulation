package com.yfs.accumulation.proxy.beans;

public class AliPayGateway implements PayGateWay{

    @Override
    public boolean pay(int userId, long orderId, double money) {
        //url pay ...
        System.out.println("支付宝支付完成了！结果 pay suceess");
        return true;
    }

    @Override
    public boolean backPay(int userId, long orderId, double money) {
        System.out.println("支付宝 退款 完成了！结果 back suceess");
        return true;
    }
}

