package com.ateng.ruankao.designpattern.factorymethod.exam;

/**
 * 软考真题圆形（具体产品）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Circle implements Graphic {

    @Override
    public void draw() {
        // 绘制圆形业务逻辑
    }

    @Override
    public String getShapeType() {
        return "圆形";
    }
}
