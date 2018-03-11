package com.yfs.accumulation.proxy.beans;

public class WeChatPayGateway implements PayGateWay {
    @Override
    public boolean pay(int userId, long orderId, double money) {
        //url pay ...
        System.out.println("微信支付支付完成了！结果 pay suceess");
        return true;
    }

    /**
     * 退款
     *
     * @param userId
     * @param orderId
     * @param money
     * @return
     */
    @Override
    public boolean backPay(int userId, long orderId, double money) {
        System.out.println("微信 退款 完成了！结果 back suceess");
        return true;
    }
}
