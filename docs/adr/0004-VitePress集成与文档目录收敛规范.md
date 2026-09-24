# 0004 VitePress 知识门户集成与全站文档目录收敛规范

## 背景与上下文

软考软件设计师知识库已完成上午综合知识 9 大学科考点精要与题库规划。为了提升阅读体验、便于多端查阅与备考复习，需要将知识库转换为现代化的静态 Web 站点，并通过 GitHub Pages 自动持续部署。在此之前，工程根目录下存在 `docs/`（内部决策记录与代理规范）与 `knowledge/`（对外学科知识）并行分散的问题，如果不进行统一收敛，VitePress 路由配置将变得割裂且复杂。

## 架构决策

1. **统一收敛至标准 `docs/` 源目录**：
   - 将原 `knowledge/am-general/` 整体迁移至 `docs/am-general/`；
   - 预留后续下午题目录 `docs/pm-applied/`；
   - 保留 `docs/adr/` 作为架构决策的公开查阅板块；
   - 彻底移除根目录 `knowledge/`，保持根目录职责纯粹（仅放置构建配置、工单目录 `.scratch/` 与工程源码 `src/`）。

2. **VitePress 站点与路由设计**：
   - 站点 base 设为 `/ruankao-software-designer/`，适配 GitHub Pages 二级子路径；
   - 保持各学科考点精要中文文件名，直接在 `.vitepress/config.mts` 中通过侧边栏（Sidebar）与导航栏（Nav）配置清晰的层级树与中文标题；
   - 引入本地全文本地化搜索支持（VitePress 内置 Local Search）。

3. **云端全自动持续部署（GitHub Actions）**：
   - 采用 `.github/workflows/deploy.yml` 自动化工作流；
   - 基于 `pnpm` 锁版本构建，将静态产物推送到 GitHub Pages 环境。

## 预期影响与权衡

- **优势**：文档目录高度内聚，VitePress 零阻碍编译；线上网页与本地 Markdown 完美同构，每次 Git 提交自动触发线上发布。
- **代价**：需同步更新部分相对路径引用，但一次性调整带来的长期维护收益极大。
