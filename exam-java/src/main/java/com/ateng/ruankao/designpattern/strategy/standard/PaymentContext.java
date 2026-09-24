package com.ateng.ruankao.designpattern.strategy.standard;

/**
 * 支付环境上下文类 (Context)：持有策略接口引用，解耦客户端与具体支付算法.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public String pay(int amount) {
        if (strategy == null) {
            throw new IllegalStateException("未指定支付策略");
        }
        return strategy.pay(amount);
    }
}
