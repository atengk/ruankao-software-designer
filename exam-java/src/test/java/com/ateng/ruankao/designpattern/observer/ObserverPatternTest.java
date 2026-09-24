package com.ateng.ruankao.designpattern.observer;

import com.ateng.ruankao.designpattern.observer.exam.CurrentConditionsDisplay;
import com.ateng.ruankao.designpattern.observer.exam.WeatherData;
import com.ateng.ruankao.designpattern.observer.standard.ConcreteObserver;
import com.ateng.ruankao.designpattern.observer.standard.ConcreteSubject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 观察者模式双轨单元测试与真题断言.
 *
 * @author Ateng
 * @since 2026-09-24
 */
@DisplayName("设计模式 - 观察者模式双轨测试")
class ObserverPatternTest {

    @Test
    @DisplayName("标准规范：主题注册、状态广播与注销")
    void testStandardObserver() {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver obs1 = new ConcreteObserver("客户端A");
        ConcreteObserver obs2 = new ConcreteObserver("客户端B");

        subject.attach(obs1);
        subject.attach(obs2);
        assertThat(subject.getObservers()).hasSize(2);

        subject.setState("版本 2.0 发布");
        assertThat(obs1.getReceivedState()).isEqualTo("版本 2.0 发布");
        assertThat(obs2.getReceivedState()).isEqualTo("版本 2.0 发布");

        subject.detach(obs1);
        assertThat(subject.getObservers()).hasSize(1);

        subject.setState("版本 2.1 发布");
        assertThat(obs1.getReceivedState()).isEqualTo("版本 2.0 发布"); // 未收到更新
        assertThat(obs2.getReceivedState()).isEqualTo("版本 2.1 发布"); // 收到新更新
    }

    @Test
    @DisplayName("软考真题原型：气象站数据变更自动广播与看板更新")
    void testExamWeatherDataObserver() {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay display1 = new CurrentConditionsDisplay(weatherData);

        // 发布第一次气象数据
        weatherData.setMeasurements(25.5f, 65.0f, 1013.25f);
        assertThat(display1.getTemperature()).isEqualTo(25.5f);
        assertThat(display1.getHumidity()).isEqualTo(65.0f);
        assertThat(display1.display()).contains("25.5℃").contains("65.0%");

        // 发布第二次气象数据
        weatherData.setMeasurements(28.0f, 70.5f, 1010.0f);
        assertThat(display1.getTemperature()).isEqualTo(28.0f);
        assertThat(display1.getHumidity()).isEqualTo(70.5f);

        // 注销观察者
        weatherData.removeObserver(display1);
        weatherData.setMeasurements(30.0f, 80.0f, 1008.0f);
        // 已注销，display1 数据应保持注销前的值
        assertThat(display1.getTemperature()).isEqualTo(28.0f);
    }
}
