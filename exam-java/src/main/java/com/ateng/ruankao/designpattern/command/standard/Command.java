package com.ateng.ruankao.designpattern.command.standard;

/**
 * 命令模式抽象命令接口.
 *
 * @author Ateng
 * @since 2026-09-24
 */
public interface Command {

    /**
     * 执行命令操作.
     */
    void execute();

    /**
     * 撤销命令操作.
     */
    void undo();
}
