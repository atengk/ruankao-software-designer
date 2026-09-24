package com.ateng.ruankao.designpattern.decorator;

import com.ateng.ruankao.designpattern.decorator.exam.Coffee;
import com.ateng.ruankao.designpattern.decorator.exam.MilkDecorator;
import com.ateng.ruankao.designpattern.decorator.exam.SimpleCoffee;
import com.ateng.ruankao.designpattern.decorator.exam.SugarDecorator;
import com.ateng.ruankao.designpattern.decorator.standard.Beverage;
import com.ateng.ruankao.designpattern.decorator.standard.Espresso;
import com.ateng.ruankao.designpattern.decorator.standard.Mocha;
import com.ateng.ruankao.designpattern.decorator.standard.Whip;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 装饰器模式双轨单元测试与真题断言.
 *
 * @author Ateng
 * @since 2026-09-24
 */
@DisplayName("设计模式 - 装饰器模式双轨测试")
class DecoratorPatternTest {

    @Test
    @DisplayName("标准规范：单层与多层嵌套装饰计价")
    void testStandardDecorator() {
        Beverage espresso = new Espresso();
        assertThat(espresso.getDescription()).isEqualTo("意式浓缩咖啡");
        assertThat(espresso.cost()).isEqualTo(20.0);

        // 加一层摩卡
        Beverage mochaEspresso = new Mocha(espresso);
        assertThat(mochaEspresso.getDescription()).isEqualTo("意式浓缩咖啡 + 摩卡");
        assertThat(mochaEspresso.cost()).isEqualTo(25.0);

        // 再加一层奶泡（多层嵌套包装）
        Beverage doubleMochaWhip = new Whip(new Mocha(espresso));
        assertThat(doubleMochaWhip.getDescription()).isEqualTo("意式浓缩咖啡 + 摩卡 + 奶泡");
        assertThat(doubleMochaWhip.cost()).isEqualTo(28.0);
    }

    @Test
    @DisplayName("软考真题原型：原味咖啡嵌套牛奶与加糖叠加计价")
    void testExamCoffeeDecorator() {
        Coffee simpleCoffee = new SimpleCoffee();
        assertThat(simpleCoffee.getDescription()).isEqualTo("原味咖啡");
        assertThat(simpleCoffee.getCost()).isEqualTo(10.0);

        // 咖啡 + 牛奶
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        assertThat(milkCoffee.getDescription()).isEqualTo("原味咖啡 + 牛奶");
        assertThat(milkCoffee.getCost()).isEqualTo(13.0);

        // 咖啡 + 牛奶 + 糖
        Coffee sweetMilkCoffee = new SugarDecorator(milkCoffee);
        assertThat(sweetMilkCoffee.getDescription()).isEqualTo("原味咖啡 + 牛奶 + 蔗糖");
        assertThat(sweetMilkCoffee.getCost()).isEqualTo(14.5);
    }
}
