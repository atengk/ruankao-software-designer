package com.ateng.ruankao.designpattern.command.exam;

/**
 * 软考真题打开电视命令 (ConcreteCommand).
 *
 * @author Ateng
 * @since 2026-09-24
 */
// 【题眼 1】：实现 Command 接口
public class OpenTvCommand implements Command {

    // 【题眼 2】：聚合业务接收者引用
    private final TvReceiver tv;

    public OpenTvCommand(TvReceiver tv) {
        if (tv == null) {
            throw new IllegalArgumentException("电视机接收者不能为空");
        }
        this.tv = tv;
    }

    @Override
    public void execute() {
        // 【题眼 3】：委托调用接收者的实际动作
        tv.on();
    }
}
