package com.ateng.ruankao.designpattern.decorator.exam;

/**
 * 软考真题咖啡抽象构件接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface Coffee {

    /**
     * 获取咖啡描述.
     *
     * @return 描述
     */
    String getDescription();

    /**
     * 获取咖啡价格.
     *
     * @return 金额
     */
    double getCost();
}
