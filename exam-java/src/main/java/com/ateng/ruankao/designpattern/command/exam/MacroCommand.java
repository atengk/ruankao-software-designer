package com.ateng.ruankao.designpattern.command.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * 软考真题宏命令（组合命令模式 MacroCommand）.
 *
 * @author Ateng
 * @since 2026-09-24
 */
// 【题眼 1】：宏命令本身也必须实现 Command 接口，具备透明性
public class MacroCommand implements Command {

    // 【题眼 2】：维护命令列表容器
    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        if (command != null) {
            commands.add(command);
        }
    }

    @Override
    public void execute() {
        // 【题眼 3】：遍历各子命令，依次调用 execute 方法
        for (Command command : commands) {
            command.execute();
        }
    }

    public int getCommandCount() {
        return commands.size();
    }
}
