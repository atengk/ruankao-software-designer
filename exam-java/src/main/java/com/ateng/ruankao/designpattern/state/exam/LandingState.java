package com.ateng.ruankao.designpattern.state.exam;

/**
 * 软考真题降落状态 (LandingState).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class LandingState implements FlightState {

    @Override
    public void takeoff(Aircraft aircraft) {
        // 正在降落，无法直接起飞
    }

    @Override
    public void fly(Aircraft aircraft) {
        // 正在进近降落
    }

    @Override
    public void land(Aircraft aircraft) {
        // 降落触地滑跑，完成降落后恢复至滑行状态
        aircraft.setState(new TaxiState());
    }

    @Override
    public String getStateName() {
        return "LANDING";
    }
}
