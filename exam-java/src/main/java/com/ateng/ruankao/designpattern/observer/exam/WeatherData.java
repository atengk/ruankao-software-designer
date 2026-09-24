package com.ateng.ruankao.designpattern.observer.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * 软考真题气象站具体主题类 (WeatherData).
 *
 * @author Ateng
 * @since 2026-09-24
 */
// 【题眼 1】：实现 Subject 接口
public class WeatherData implements Subject {

    // 【题眼 2】：维护观察者集合（组合关系）
    private final List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        // 【题眼 3】：遍历观察者集合，循环调用 update 方法广播最新状态
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * 当传感器采集到新数据时调用.
     */
    public void measurementsChanged() {
        // 【题眼 4】：数据改变后主动触发广播
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
