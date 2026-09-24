package com.ateng.ruankao.designpattern.decorator.exam;

/**
 * 软考真题原味黑咖啡（具体构件）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "原味咖啡";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
}
