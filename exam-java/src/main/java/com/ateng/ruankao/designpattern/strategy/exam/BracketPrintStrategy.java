package com.ateng.ruankao.designpattern.strategy.exam;

/**
 * 2023 年机考真题原型：中括号逗号风格打印具体策略.
 *
 * @author Ateng
 * @since 2026-09-24
 */
// 【机考填空 (5)】：实现 PrintStrategy 接口
public class BracketPrintStrategy implements PrintStrategy {

    @Override
    public void doPrint(Interval interval) {
        String result = "[" + interval.getLower() + ", " + interval.getUpper() + "]";
        interval.setLastPrintedResult(result);
    }
}
