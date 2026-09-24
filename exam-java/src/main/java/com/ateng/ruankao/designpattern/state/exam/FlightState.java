package com.ateng.ruankao.designpattern.state.exam;

/**
 * 软考真题飞行器抽象状态接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface FlightState {

    /**
     * 【题眼 1】：方法签名接收上下文引用，以便在状态变更时驱动上下文状态跃迁.
     *
     * @param aircraft 飞行器上下文
     */
    void takeoff(Aircraft aircraft);

    void fly(Aircraft aircraft);

    void land(Aircraft aircraft);

    String getStateName();
}
