package com.ateng.ruankao.designpattern.command.exam;

/**
 * 软考真题遥控器调用者 (Invoker).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class RemoteControl {

    // 【题眼 1】：持有命令接口引用，面向接口编程
    private Command slot;

    // 【题眼 2】：动态注入或切换具体命令
    public void setCommand(Command slot) {
        this.slot = slot;
    }

    // 【题眼 3】：按下按键时触发命令执行
    public void buttonWasPressed() {
        if (slot != null) {
            slot.execute();
        }
    }
}
