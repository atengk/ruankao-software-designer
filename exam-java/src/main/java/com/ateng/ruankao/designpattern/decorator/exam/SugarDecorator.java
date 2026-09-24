package com.ateng.ruankao.designpattern.decorator.exam;

/**
 * 软考真题加糖装饰器（具体装饰器）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + 蔗糖";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}
