package com.ateng.ruankao.designpattern.decorator.standard;

/**
 * 摩卡调料装饰器 (ConcreteDecorator).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + 摩卡";
    }

    @Override
    public double cost() {
        return beverage.cost() + 5.0;
    }
}
