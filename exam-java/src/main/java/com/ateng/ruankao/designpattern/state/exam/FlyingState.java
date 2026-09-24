package com.ateng.ruankao.designpattern.state.exam;

/**
 * 软考真题巡航飞行状态 (FlyingState).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class FlyingState implements FlightState {

    @Override
    public void takeoff(Aircraft aircraft) {
        // 已处于巡航中，无需起飞
    }

    @Override
    public void fly(Aircraft aircraft) {
        // 保持平稳飞行
    }

    @Override
    public void land(Aircraft aircraft) {
        // 收到降落指令，跃迁至降落状态
        aircraft.setState(new LandingState());
    }

    @Override
    public String getStateName() {
        return "FLYING";
    }
}
