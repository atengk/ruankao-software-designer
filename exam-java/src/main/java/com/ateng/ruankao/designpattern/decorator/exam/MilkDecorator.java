package com.ateng.ruankao.designpattern.decorator.exam;

/**
 * 软考真题加牛奶装饰器（具体装饰器）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
// 【题眼 1】：继承抽象装饰器 CoffeeDecorator
public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + 牛奶";
    }

    @Override
    public double getCost() {
        // 【题眼 2】：调用父类（或被包装对象）计价方法并叠加自身成本
        return super.getCost() + 3.0;
    }
}
