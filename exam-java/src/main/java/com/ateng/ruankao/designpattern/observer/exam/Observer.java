package com.ateng.ruankao.designpattern.observer.exam;

/**
 * 软考历年真题观察者接口（气象监测站原型）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface Observer {

    /**
     * 当气象观测数据改变时接收通知.
     *
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    void update(float temp, float humidity, float pressure);
}
