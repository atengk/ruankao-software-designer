package com.ateng.ruankao.designpattern.decorator.standard;

/**
 * 意式浓缩咖啡（具体构件 ConcreteComponent）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Espresso implements Beverage {

    @Override
    public String getDescription() {
        return "意式浓缩咖啡";
    }

    @Override
    public double cost() {
        return 20.0;
    }
}
