package com.ateng.ruankao.designpattern.factorymethod;

import com.ateng.ruankao.designpattern.factorymethod.exam.CircleFactory;
import com.ateng.ruankao.designpattern.factorymethod.exam.Graphic;
import com.ateng.ruankao.designpattern.factorymethod.exam.GraphicFactory;
import com.ateng.ruankao.designpattern.factorymethod.exam.RectangleFactory;
import com.ateng.ruankao.designpattern.factorymethod.standard.ConcreteFactoryA;
import com.ateng.ruankao.designpattern.factorymethod.standard.ConcreteFactoryB;
import com.ateng.ruankao.designpattern.factorymethod.standard.Factory;
import com.ateng.ruankao.designpattern.factorymethod.standard.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 工厂方法模式双轨单元测试与真题断言.
 *
 * @author Ateng
 * @since 2026-09-24
 */
@DisplayName("设计模式 - 工厂方法模式双轨测试")
class FactoryMethodPatternTest {

    @Test
    @DisplayName("标准规范：不同工厂生产对应具体产品")
    void testStandardFactoryMethod() {
        Factory factoryA = new ConcreteFactoryA();
        Product productA = factoryA.createProduct();
        assertThat(productA.getInfo()).isEqualTo("具体产品A");

        Factory factoryB = new ConcreteFactoryB();
        Product productB = factoryB.createProduct();
        assertThat(productB.getInfo()).isEqualTo("具体产品B");
    }

    @Test
    @DisplayName("软考真题原型：图形工厂多态实例化")
    void testExamGraphicFactory() {
        GraphicFactory circleFactory = new CircleFactory();
        Graphic circle = circleFactory.createGraphic();
        assertThat(circle.getShapeType()).isEqualTo("圆形");

        GraphicFactory rectangleFactory = new RectangleFactory();
        Graphic rectangle = rectangleFactory.createGraphic();
        assertThat(rectangle.getShapeType()).isEqualTo("矩形");
    }
}
