package com.ateng.ruankao.designpattern.command.standard;

/**
 * 命令模式请求调用者 (Invoker).
 * 负责触发命令执行，解耦请求发起者与请求执行者.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute();
        }
    }

    public void undoCommand() {
        if (command != null) {
            command.undo();
        }
    }
}
