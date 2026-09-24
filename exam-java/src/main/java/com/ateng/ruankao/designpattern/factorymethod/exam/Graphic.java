package com.ateng.ruankao.designpattern.factorymethod.exam;

/**
 * 软考真题图形抽象产品接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface Graphic {

    /**
     * 绘制图形.
     */
    void draw();

    /**
     * 获取图形类型名称.
     *
     * @return 图形名称
     */
    String getShapeType();
}
