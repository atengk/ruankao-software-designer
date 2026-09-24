# 试题六：面向对象与设计模式 (Java 选做)

<Badge type="info" text="题型定位：选做题 · 分值: 15 分" />
<Badge type="tip" text="及格目标：13 ~ 15 分 (核心胜负手)" />
<Badge type="danger" text="核心法则：类图接口映射 · 7大高频模式 · Java双轨实战断言" />

::: tip 🎯 专栏导航与攻坚目标
选做试题六（Java 语言版本）是下午卷最重要的核心胜负手。出题 100% 围绕 GoF 23 种设计模式展开。通过本项目构建的 `exam-java` 实战工程，可实现代码双轨运行与真题填空断言。

- 本专栏即将在工单 [#17](https://github.com/atengk/ruankao-software-designer/issues/17) 中全面交付；
- 覆盖策略、观察者、装饰器、工厂方法、适配器、命令、状态 7 大高频模式的双轨实现与机考填空精解。
:::

---

## 核心方法论大纲

1. **Java 代码填空 5 个空的命题规律**：
   - 空 1：接口或抽象父类继承声明（`implements` / `extends`）；
   - 空 2：成员变量多态接口声明（`private Strategy strategy;`）；
   - 空 3：构造器注入或 Setter 方法绑定；
   - 空 4：抽象方法重写实现签名；
   - 空 5：多态委托调用语句（`strategy.execute();`）。
2. **7 大金牌高频模式清单**：
   - 策略模式 (Strategy)
   - 观察者模式 (Observer)
   - 装饰器模式 (Decorator)
   - 工厂方法模式 (Factory Method)
   - 适配器模式 (Adapter)
   - 命令模式 (Command)
   - 状态模式 (State)
3. **双轨验证工程 (exam-java)**：标准抽象骨架 + 真实机考真题复现 + JUnit 5 行为测试用例。
