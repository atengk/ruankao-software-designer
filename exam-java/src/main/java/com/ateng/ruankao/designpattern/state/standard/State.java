package com.ateng.ruankao.designpattern.state.standard;

/**
 * 状态模式抽象状态接口 (State).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface State {

    /**
     * 处理特定状态下的业务行为并驱动状态跃迁.
     *
     * @param context 状态机上下文
     */
    void handle(Context context);

    /**
     * 获取状态标识名称.
     *
     * @return 状态名称
     */
    String getStateName();
}
