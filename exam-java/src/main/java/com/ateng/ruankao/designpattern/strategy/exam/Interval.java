package com.ateng.ruankao.designpattern.strategy.exam;

/**
 * 2023 年机考真题原型：区间上下文类 (Context).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Interval {

    private final double lower;
    private final double upper;

    // 【机考填空 (2)】：Context 持有策略接口的引用
    private PrintStrategy printStrategy;

    // 记录最近一次格式化输出结果，便于单元测试断言
    private String lastPrintedResult;

    public Interval(double lower, double upper) {
        this.lower = lower;
        this.upper = upper;
    }

    // 【机考填空 (3)】：Setter 注入具体策略
    public void setPrintStrategy(PrintStrategy printStrategy) {
        this.printStrategy = printStrategy;
    }

    // 【机考填空 (4)】：多态委托调用具体策略方法
    public void printFormat() {
        if (printStrategy != null) {
            printStrategy.doPrint(this);
        }
    }

    public double getLower() {
        return lower;
    }

    public double getUpper() {
        return upper;
    }

    public String getLastPrintedResult() {
        return lastPrintedResult;
    }

    public void setLastPrintedResult(String lastPrintedResult) {
        this.lastPrintedResult = lastPrintedResult;
    }
}
