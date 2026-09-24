package com.ateng.ruankao.designpattern.strategy.exam;

/**
 * 2023 年机考真题原型：区间打印策略接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface PrintStrategy {

    /**
     * 【机考填空 (1)】：定义执行策略输出的核心抽象方法.
     *
     * @param interval 待打印的区间对象
     */
    void doPrint(Interval interval);
}
