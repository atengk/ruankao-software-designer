package com.ateng.ruankao.designpattern.command.exam;

/**
 * 软考真题关闭电视命令 (ConcreteCommand).
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class CloseTvCommand implements Command {

    private final TvReceiver tv;

    public CloseTvCommand(TvReceiver tv) {
        if (tv == null) {
            throw new IllegalArgumentException("电视机接收者不能为空");
        }
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }
}
