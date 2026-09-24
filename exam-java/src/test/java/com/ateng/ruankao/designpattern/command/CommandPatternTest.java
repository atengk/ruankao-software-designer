package com.ateng.ruankao.designpattern.command;

import com.ateng.ruankao.designpattern.command.exam.CloseTvCommand;
import com.ateng.ruankao.designpattern.command.exam.MacroCommand;
import com.ateng.ruankao.designpattern.command.exam.OpenTvCommand;
import com.ateng.ruankao.designpattern.command.exam.RemoteControl;
import com.ateng.ruankao.designpattern.command.exam.TvReceiver;
import com.ateng.ruankao.designpattern.command.standard.ConcreteCommand;
import com.ateng.ruankao.designpattern.command.standard.Invoker;
import com.ateng.ruankao.designpattern.command.standard.Receiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 命令模式双轨单元测试与真题断言.
 *
 * @author Ateng
 * @since 2026-09-24
 */
@DisplayName("设计模式 - 命令模式双轨测试")
class CommandPatternTest {

    @Test
    @DisplayName("标准规范：调用者触发命令执行与撤销")
    void testStandardCommand() {
        Receiver receiver = new Receiver();
        assertThat(receiver.isActive()).isFalse();

        ConcreteCommand command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);

        invoker.executeCommand();
        assertThat(receiver.isActive()).isTrue();

        invoker.undoCommand();
        assertThat(receiver.isActive()).isFalse();
    }

    @Test
    @DisplayName("软考真题原型：遥控器单命令与宏命令顺序执行")
    void testExamTvRemoteCommand() {
        TvReceiver tv = new TvReceiver();
        RemoteControl remote = new RemoteControl();

        // 单命令：开机
        remote.setCommand(new OpenTvCommand(tv));
        remote.buttonWasPressed();
        assertThat(tv.isTurnedOn()).isTrue();

        // 单命令：关机
        remote.setCommand(new CloseTvCommand(tv));
        remote.buttonWasPressed();
        assertThat(tv.isTurnedOn()).isFalse();

        // 宏命令：批处理组合
        MacroCommand macro = new MacroCommand();
        macro.addCommand(new OpenTvCommand(tv));
        macro.addCommand(new CloseTvCommand(tv));
        macro.addCommand(new OpenTvCommand(tv));
        assertThat(macro.getCommandCount()).isEqualTo(3);

        remote.setCommand(macro);
        remote.buttonWasPressed();
        assertThat(tv.isTurnedOn()).isTrue();
    }
}
