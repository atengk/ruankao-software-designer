package com.ateng.ruankao.designpattern.state.standard;

/**
 * 具体状态 A：处理完毕后自动跃迁至状态 B.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class ConcreteStateA implements State {

    @Override
    public void handle(Context context) {
        // 状态行为执行后自动推进状态跃迁
        context.setState(new ConcreteStateB());
    }

    @Override
    public String getStateName() {
        return "STATE_A";
    }
}
