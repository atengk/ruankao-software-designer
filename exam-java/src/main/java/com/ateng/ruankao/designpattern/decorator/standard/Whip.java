package com.ateng.ruankao.designpattern.decorator.standard;

/**
 * 奶泡调料装饰器 (ConcreteDecorator).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + 奶泡";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3.0;
    }
}
