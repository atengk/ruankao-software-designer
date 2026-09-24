# 试题三：面向对象分析与 UML 建模

<Badge type="info" text="题型定位：必答题 · 分值: 15 分" />
<Badge type="tip" text="及格目标：12 ~ 14 分 (核心得分盘)" />
<Badge type="danger" text="核心法则：类间耦合强弱阶梯 · 用例三大关系 · 多重度标注" />

::: tip 🎯 专栏导航与攻坚目标
试题三考查面向对象静态与动态图谱。重点攻坚类图（聚合 vs 组合）、用例图（包含 vs 扩展 vs 泛化）与多重度推导。

- 本专栏即将在工单 [#19](https://github.com/atengk/ruankao-software-designer/issues/19) 中全面交付；
- 包含智能车载导航、线上支付网关、敏捷看板协作 3 大面向对象系统 Mermaid 矢量图谱案例。
:::

---

## 核心方法论大纲

1. **类间耦合强弱阶梯**：
   $$\text{依赖 (Dependency)} < \text{关联 (Association)} < \text{聚合 (Aggregation)} < \text{组合 (Composition)} < \text{泛化/实现 (Generalization/Realization)}$$
   - 聚合（空心菱形）：生命周期解耦；
   - 组合（实心菱形）：生命周期绑定（同生共死）。
2. **用例图三大关系判别口诀**：
   - 包含 `<<include>>`：必选、强制执行；
   - 扩展 `<<extend>>`：可选、条件触发；
   - 泛化：父子抽象与特化继承。
3. **多重度与动态行为图**：`0..1`, `1`, `*`, `1..*` 标注，时序图消息时序，状态图状态转换与守卫条件。
