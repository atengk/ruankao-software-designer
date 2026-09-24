package com.ateng.ruankao.designpattern.observer.exam;

/**
 * 软考真题当前天气看板（具体观察者实现）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
// 【题眼 1】：实现 Observer 接口
public class CurrentConditionsDisplay implements Observer {

    private float temperature;
    private float humidity;
    private final Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        // 【题眼 2】：在构造函数中把自己注册到主题中
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        // 【题眼 3】：更新自身持有的状态字段
        this.temperature = temp;
        this.humidity = humidity;
    }

    public String display() {
        return "当前状况: 温度 " + temperature + "℃, 湿度 " + humidity + "%";
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }
}
