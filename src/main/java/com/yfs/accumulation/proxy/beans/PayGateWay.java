package com.yfs.accumulation.proxy.beans;

public interface PayGateWay {

    /**
     * 支付
     * @param userId
     * @param orderId
     * @param money
     * @return
     */
    public boolean pay(int userId, long orderId, double money);

    /**
     * 退款
     * @param userId
     * @param orderId
     * @param money
     * @return
     */
    public boolean backPay(int userId, long orderId, double money);



}



