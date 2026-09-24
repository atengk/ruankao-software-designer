package com.ateng.ruankao.designpattern.decorator.standard;

/**
 * 调料装饰器抽象类 (Decorator).
 * 既实现 Beverage 接口，又聚合 Beverage 对象（软考经典双重关系）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public abstract class CondimentDecorator implements Beverage {

    protected final Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        if (beverage == null) {
            throw new IllegalArgumentException("被装饰的饮品对象不能为空");
        }
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double cost() {
        return beverage.cost();
    }
}
