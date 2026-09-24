package com.ateng.ruankao.designpattern.decorator.standard;

/**
 * 装饰器模式抽象构件 (Component).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface Beverage {

    /**
     * 获取饮品描述.
     *
     * @return 饮品描述信息
     */
    String getDescription();

    /**
     * 计算饮品总费用.
     *
     * @return 价格（元）
     */
    double cost();
}
