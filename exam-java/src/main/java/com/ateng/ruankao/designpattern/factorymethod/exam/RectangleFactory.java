package com.ateng.ruankao.designpattern.factorymethod.exam;

/**
 * 软考真题矩形工厂类.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class RectangleFactory implements GraphicFactory {

    @Override
    public Graphic createGraphic() {
        // 【题眼 2】：具体工厂返回具体产品实例
        return new Rectangle();
    }
}
