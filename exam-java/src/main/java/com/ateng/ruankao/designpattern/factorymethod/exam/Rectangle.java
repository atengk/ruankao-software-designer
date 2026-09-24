package com.ateng.ruankao.designpattern.factorymethod.exam;

/**
 * 软考真题矩形（具体产品）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Rectangle implements Graphic {

    @Override
    public void draw() {
        // 绘制矩形业务逻辑
    }

    @Override
    public String getShapeType() {
        return "矩形";
    }
}
