package com.ateng.ruankao.designpattern.factorymethod.standard;

/**
 * 具体工厂 B.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class ConcreteFactoryB implements Factory {

    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}
