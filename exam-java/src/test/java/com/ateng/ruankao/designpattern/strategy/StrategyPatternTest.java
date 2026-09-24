package com.ateng.ruankao.designpattern.strategy;

import com.ateng.ruankao.designpattern.strategy.exam.BracketPrintStrategy;
import com.ateng.ruankao.designpattern.strategy.exam.DotPrintStrategy;
import com.ateng.ruankao.designpattern.strategy.exam.Interval;
import com.ateng.ruankao.designpattern.strategy.standard.CreditCardPayment;
import com.ateng.ruankao.designpattern.strategy.standard.PaymentContext;
import com.ateng.ruankao.designpattern.strategy.standard.WeChatPayment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 策略模式双轨单元测试与真题断言.
 *
 * @author Ateng
 * @since 2026-09-24
 */
class StrategyPatternTest {

    @Test
    @DisplayName("标准策略模式：动态切换信用卡与微信支付算法")
    void testStandardPaymentStrategy() {
        PaymentContext context = new PaymentContext(new CreditCardPayment("6222-0001-8888"));
        String res1 = context.pay(100);
        assertThat(res1).contains("信用卡").contains("100元");

        // 动态替换策略为微信支付
        context.setStrategy(new WeChatPayment("wx_user_999"));
        String res2 = context.pay(200);
        assertThat(res2).contains("微信用户").contains("200元");
    }

    @Test
    @DisplayName("标准策略模式：未设置策略时防御性抛出状态异常")
    void testStandardStrategyUnsetDefense() {
        PaymentContext context = new PaymentContext(null);
        assertThatThrownBy(() -> context.pay(50))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("未指定支付策略");
    }

    @Test
    @DisplayName("2023机考真题复现：Interval区间格式化策略动态切换断言")
    void testExamIntervalFormattingStrategy() {
        Interval interval = new Interval(10.5, 20.8);

        // 填空测试：使用 BracketPrintStrategy 打印
        interval.setPrintStrategy(new BracketPrintStrategy());
        interval.printFormat();
        assertThat(interval.getLastPrintedResult()).isEqualTo("[10.5, 20.8]");

        // 填空测试：切换为 DotPrintStrategy 打印
        interval.setPrintStrategy(new DotPrintStrategy());
        interval.printFormat();
        assertThat(interval.getLastPrintedResult()).isEqualTo("[10.5...20.8]");
    }
}
