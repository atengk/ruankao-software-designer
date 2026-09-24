package com.ateng.ruankao.designpattern.state.exam;

/**
 * 软考真题飞行器上下文类 (Context).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Aircraft {

    // 【题眼 2】：持有当前抽象状态引用
    private FlightState state;

    public Aircraft() {
        // 初始状态为滑行状态
        this.state = new TaxiState();
    }

    public void setState(FlightState state) {
        if (state != null) {
            this.state = state;
        }
    }

    public FlightState getState() {
        return state;
    }

    public void takeoff() {
        // 【题眼 3】：将动作委托给当前状态对象执行，并把自己 (this) 作为参数回传
        state.takeoff(this);
    }

    public void fly() {
        state.fly(this);
    }

    public void land() {
        state.land(this);
    }
}
