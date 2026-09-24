package com.ateng.ruankao.designpattern.state.standard;

/**
 * 状态模式上下文环境类 (Context).
 * 维护当前所处状态并向客户端提供业务接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Context {

    private State state;

    public Context(State initialState) {
        if (initialState == null) {
            throw new IllegalArgumentException("初始状态不能为空");
        }
        this.state = initialState;
    }

    public void request() {
        state.handle(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
