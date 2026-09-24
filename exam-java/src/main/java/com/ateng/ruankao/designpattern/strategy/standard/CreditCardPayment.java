package com.ateng.ruankao.designpattern.strategy.standard;

/**
 * 信用卡支付具体策略类.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String pay(int amount) {
        return "信用卡[" + cardNumber + "]支付成功: " + amount + "元";
    }
}
