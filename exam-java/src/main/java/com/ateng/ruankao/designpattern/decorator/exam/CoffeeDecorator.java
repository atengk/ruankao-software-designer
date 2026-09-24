package com.ateng.ruankao.designpattern.decorator.exam;

/**
 * 软考真题咖啡抽象装饰器.
 *
 * @author Ateng
 * @since 2026-09-24
 */
// 【题眼 1】：实现 Coffee 接口（与构件同源）
public abstract class CoffeeDecorator implements Coffee {

    // 【题眼 2】：声明被装饰的 Coffee 引用（组合关系）
    protected final Coffee decoratedCoffee;

    // 【题眼 3】：构造方法注入被装饰对象
    public CoffeeDecorator(Coffee decoratedCoffee) {
        if (decoratedCoffee == null) {
            throw new IllegalArgumentException("被装饰的咖啡对象不能为空");
        }
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
