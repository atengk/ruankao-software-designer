package com.ateng.ruankao.designpattern.strategy.exam;

/**
 * 2023 年机考真题原型：省略号范围风格打印具体策略.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class DotPrintStrategy implements PrintStrategy {

    @Override
    public void doPrint(Interval interval) {
        String result = "[" + interval.getLower() + "..." + interval.getUpper() + "]";
        interval.setLastPrintedResult(result);
    }
}
