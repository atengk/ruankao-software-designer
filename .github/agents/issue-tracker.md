# 任务跟踪器：GitHub Issues

本项目的需求、考点攻坚任务与机考真题复盘统一使用 **GitHub Issues** 进行全生命周期管理，作为项目唯一事实来源 (Single Source of Truth, SSOT)。

远程仓库：[atengk/ruankao-software-designer](https://github.com/atengk/ruankao-software-designer/issues)

---

## 一、 规范与约定

### 1. Issue 标题命名规范
统一遵循提纲化格式：`[<模块或专题>] <序号或阶段> - <核心任务描述>`。
例如：
- `[上午题] 07 - 第三第四梯队 2024 真题替换与全科《机考高频易错避坑与秒杀模板库》建设`
- `[下午题] 01 - 数据流图 DFD 外部实体与数据存储解题模版梳理`
- `[题库避坑] 2024机考 树多度数叶子节点联立方程求解陷阱`

### 2. Issue 正文结构契约
工单正文统一包含以下关键段落：
- **🎯 构建目标 (Objective)**：阐明该任务的核心交付物与业务价值（如及格 45 分分级、最新机考真题替换等）。
- **📚 涉及模块与文档 (Scope & Files)**：列出影响的文档相对路径（如 `docs/am-general/01-computer-architecture/`）。
- **⛓️ 前置依赖 (Blocked by)**：注明依赖的前置 Issue 编号（如 `Blocked by #6`）。
- **✅ 验收标准 (Acceptance Criteria)**：可勾选的 Markdown Checklist 列表（`- [ ]` / `- [x]`）。
- **📝 推进记录 (Progress Notes)**：在底部追加推进日期与动作摘要。

### 3. 分诊状态与标签 (Labels)
依托 GitHub Labels 管理状态流转（详见 `triage-labels.md`）：
- **状态标签**：`needs-triage`、`needs-info`、`ready-for-agent`、`ready-for-human`、`wontfix`。
- **学科与专题标签**：`am-general`（上午综合知识）、`pm-case`（下午案例分析）、`bug`（错题纠错）、`documentation`（文档完善）等。

---

## 二、 代理与开发者交互指南 (GitHub CLI)

统一通过系统 `gh` CLI 进行非侵入式、自动化交互。

### 1. 查询待办任务 (Ready for Agent)
筛选出代理就绪且处于开启状态的工单：
```bash
gh issue list --state open --label "ready-for-agent"
```

### 2. 当技能提示“获取关联任务”时
查看指定编号任务的详情或评论上下文：
```bash
gh issue view <Issue编号>
gh issue view <Issue编号> --comments
```

### 3. 当技能提示“发布至任务跟踪器”时
使用 `gh issue create`，优先配合模板或临时 Markdown 暂存文件提交：
```bash
gh issue create --title "[<专题>] <任务标题>" --body-file "<暂存路径>" --label "ready-for-agent,am-general"
```

### 4. 认领与更新任务状态
添加评论或变更分诊状态：
```bash
# 添加推进评论
gh issue comment <Issue编号> --body "已认领该任务，正在开展知识点梳理..."

# 变更标签（如由待分诊转为代理就绪）
gh issue edit <Issue编号> --remove-label "needs-triage" --add-label "ready-for-agent"
```

### 5. 验收并关闭任务
当验收标准全部满足并通过全站构建测试后，执行关闭：
```bash
gh issue close <Issue编号> --comment "全量验收标准已通过，知识库与测试闭环交付。"
```

---

## 三、 本地 `.scratch/` 目录演化说明

- **原有 `.scratch/` 职责**：此前存放本地 Markdown 工单（现已全量迁移至 GitHub Issues）。
- **当前定位**：`.scratch/` 降级为本地草稿、离线演算与一次性探针暂存区，不再作为全局任务跟踪器；主要任务、考点与进度以 GitHub Issues 为准。
