package com.ateng.ruankao.designpattern.command.standard;

/**
 * 命令模式业务接收者 (Receiver).
 * 真正执行实际业务逻辑的对象.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public class Receiver {

    private boolean active = false;

    public void action() {
        this.active = true;
    }

    public void undoAction() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }
}
