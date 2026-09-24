package com.ateng.ruankao.designpattern.state;

import com.ateng.ruankao.designpattern.state.exam.Aircraft;
import com.ateng.ruankao.designpattern.state.standard.ConcreteStateA;
import com.ateng.ruankao.designpattern.state.standard.Context;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 状态模式双轨单元测试与真题断言.
 *
 * @author Ateng
 * @since 2026-09-24
 */
@DisplayName("设计模式 - 状态模式双轨测试")
class StatePatternTest {

    @Test
    @DisplayName("标准规范：状态行为驱动状态自动交替跃迁")
    void testStandardState() {
        Context context = new Context(new ConcreteStateA());
        assertThat(context.getState().getStateName()).isEqualTo("STATE_A");

        // 第一次请求：A 自动跃迁至 B
        context.request();
        assertThat(context.getState().getStateName()).isEqualTo("STATE_B");

        // 第二次请求：B 自动跃迁回 A
        context.request();
        assertThat(context.getState().getStateName()).isEqualTo("STATE_A");
    }

    @Test
    @DisplayName("软考真题原型：飞行器滑行、起飞巡航与降落生命周期状态跃迁")
    void testExamAircraftStateLifecycle() {
        Aircraft aircraft = new Aircraft();
        // 初始状态：滑行中
        assertThat(aircraft.getState().getStateName()).isEqualTo("TAXI");

        // 执行起飞：跃迁至巡航状态
        aircraft.takeoff();
        assertThat(aircraft.getState().getStateName()).isEqualTo("FLYING");

        // 发起降落指令：跃迁至降落进近状态
        aircraft.land();
        assertThat(aircraft.getState().getStateName()).isEqualTo("LANDING");

        // 触地滑跑完成：恢复至地面滑行状态
        aircraft.land();
        assertThat(aircraft.getState().getStateName()).isEqualTo("TAXI");
    }
}
