package com.ateng.ruankao.designpattern.command.standard;

/**
 * 命令模式具体命令实现类.
 * 将接收者动作封装为命令对象.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class ConcreteCommand implements Command {

    private final Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        if (receiver == null) {
            throw new IllegalArgumentException("接收者对象不能为空");
        }
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }

    @Override
    public void undo() {
        receiver.undoAction();
    }
}
