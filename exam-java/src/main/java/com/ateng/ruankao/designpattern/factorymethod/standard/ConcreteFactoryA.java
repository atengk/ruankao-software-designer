package com.ateng.ruankao.designpattern.factorymethod.standard;

/**
 * 具体工厂 A.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class ConcreteFactoryA implements Factory {

    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}
