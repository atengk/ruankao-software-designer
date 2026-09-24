package com.ateng.ruankao.designpattern.observer.standard;

/**
 * 观察者接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface Observer {

    /**
     * 当被观察目标状态改变时触发此更新通知.
     *
     * @param message 广播消息
     */
    void update(String message);
}
