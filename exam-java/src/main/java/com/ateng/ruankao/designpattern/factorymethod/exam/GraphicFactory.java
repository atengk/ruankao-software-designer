package com.ateng.ruankao.designpattern.factorymethod.exam;

/**
 * 软考真题图形抽象工厂接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface GraphicFactory {

    /**
     * 【题眼 1】：返回抽象产品 Graphic 类型，解耦调用者与具体实现.
     *
     * @return 图形接口
     */
    Graphic createGraphic();
}
