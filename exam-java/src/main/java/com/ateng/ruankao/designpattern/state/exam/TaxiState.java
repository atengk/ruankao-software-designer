package com.ateng.ruankao.designpattern.state.exam;

/**
 * 软考真题滑行状态 (TaxiState).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class TaxiState implements FlightState {

    @Override
    public void takeoff(Aircraft aircraft) {
        // 【题眼 4】：在当前状态动作完成后，主动驱动上下文进行状态跃迁
        aircraft.setState(new FlyingState());
    }

    @Override
    public void fly(Aircraft aircraft) {
        // 地面滑行中无法直接巡航，忽略或提示
    }

    @Override
    public void land(Aircraft aircraft) {
        // 已经在地面，无需降落
    }

    @Override
    public String getStateName() {
        return "TAXI";
    }
}
