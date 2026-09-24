package com.ateng.ruankao.designpattern.state.standard;

/**
 * 具体状态 B：处理完毕后自动回环至状态 A.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class ConcreteStateB implements State {

    @Override
    public void handle(Context context) {
        // 状态行为执行后自动推进状态跃迁
        context.setState(new ConcreteStateA());
    }

    @Override
    public String getStateName() {
        return "STATE_B";
    }
}
