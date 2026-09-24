package com.ateng.ruankao.designpattern.strategy.standard;

/**
 * 微信支付具体策略类.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class WeChatPayment implements PaymentStrategy {

    private final String openId;

    public WeChatPayment(String openId) {
        this.openId = openId;
    }

    @Override
    public String pay(int amount) {
        return "微信用户[" + openId + "]扫码支付成功: " + amount + "元";
    }
}
