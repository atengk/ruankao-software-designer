package com.ateng.ruankao.designpattern.observer.exam;

/**
 * 软考历年真题目标主题接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface Subject {

    /**
     * 注册观察者.
     *
     * @param o 观察者
     */
    void registerObserver(Observer o);

    /**
     * 注销观察者.
     *
     * @param o 观察者
     */
    void removeObserver(Observer o);

    /**
     * 通知所有已注册的观察者.
     */
    void notifyObservers();
}
