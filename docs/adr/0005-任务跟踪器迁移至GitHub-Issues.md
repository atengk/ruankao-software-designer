# 0005 任务跟踪器由本地 Markdown 迁移至 GitHub Issues

## 背景与上下文

在项目建设初期，需求、考点任务与重构工单以本地 Markdown 文件（`.scratch/<专题>/issues/*.md`）形式维护。随着备考知识库进入系统化真题重构与下午题拓展阶段，本地文件跟踪机制显现出若干局限：
1. **多端协同与可见性不足**：无法在移动端或网页端实时直观审视备考任务推进状态；
2. **状态流转与交互成本**：缺乏统一且标准化的工单状态（OPEN/CLOSED）、标签（Labels）、讨论互动与里程碑关联体系；
3. **工作区整洁性**：大量工单文件混在项目本地工作区，增加了分支合并冲突风险。

因此，决定将任务跟踪器统一迁移至 GitHub Issues，作为整个项目演进与备考推进的唯一事实来源 (SSOT)。

---

## 架构决策

1. **统一使用 GitHub Issues 作为单一真实源 (SSOT)**：
   - 全面承载考点攻坚、真题替换、避坑归纳与下午题专项等各类任务；
   - 本地 `.scratch/` 目录降级为本地草稿、零散探针演算与临时工作区，不再承担主干任务追踪职能。

2. **标签与分诊体系标准化**：
   - 在远程仓库建立与工程规范对齐的标准五阶段分诊角色标签（`needs-triage`、`needs-info`、`ready-for-agent`、`ready-for-human`、`wontfix`）；
   - 增加学科维度扩展标签（`am-general`、`pm-case` 等），便于按学科与梯队快速筛选。

3. **历史存量任务全量迁移**：
   - 通过专用迁移脚本（基于 GitHub CLI `gh` 与 Node.js）将存量工单（01 至 07）完整导入 GitHub Issues；
   - 已完成并验收的工单（01 至 06）创建后自动标记为关闭并追加归档说明；
   - 正在进行的工单（07）保持开启（OPEN），并打上 `ready-for-agent` 与 `am-general` 标签。

4. **规范化工单模板 (Issue Templates)**：
   - 设立 `.github/ISSUE_TEMPLATE/task.md`（备考攻坚工单模板）；
   - 设立 `.github/ISSUE_TEMPLATE/pitfall.md`（机考真题与避坑收录模板）；
   - 规范必须包含目标、涉及模块文件、依赖阻塞与验收标准。

5. **命令行驱动的 Agent 与开发者协作 (Tooling)**：
   - 代理或开发者统一通过 GitHub CLI (`gh issue list`, `gh issue view`, `gh issue create`, `gh issue close` 等) 自动化检视与流转任务。

---

## 预期影响与权衡

- **优势**：
  - **云端多端随时可达**：备考状态一目了然，与代码仓库、GitHub Actions 与 Pages 深度整合；
  - **Agent 交互更轻量规范**：AI 代理与开发者依托标准的 `gh` 命令操作，降低对本地复杂目录结构的依赖；
  - **历史追溯完备**：清晰沉淀知识库构建演进链路。
- **代价与权衡**：
  - 依赖网络环境与 GitHub 认证（已在本地完成 `gh auth` 配置）。
