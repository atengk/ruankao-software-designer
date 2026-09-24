package com.ateng.ruankao.designpattern.factorymethod.standard;

/**
 * 工厂方法模式抽象工厂接口 (Creator).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface Factory {

    /**
     * 工厂方法：负责延迟到子类创建具体产品.
     *
     * @return 抽象产品接口
     */
    Product createProduct();
}
