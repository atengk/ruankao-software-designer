package com.ateng.ruankao.designpattern.strategy.standard;

/**
 * 策略接口：定义所有支持的支付算法公共接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface PaymentStrategy {

    /**
     * 执行支付逻辑.
     *
     * @param amount 支付金额 (分)
     * @return 支付结果摘要
     */
    String pay(int amount);
}
