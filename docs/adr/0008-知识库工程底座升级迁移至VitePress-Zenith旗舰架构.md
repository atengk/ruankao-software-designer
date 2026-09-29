# 0008 知识库工程底座升级迁移至 VitePress Zenith 旗舰架构

## 背景与上下文

软考软件设计师备考知识库工程经过前期构建，已收录上午综合知识 9 大学科、全科公式速查手册、高频避坑秒杀库、下午应用技术 5 大题型案例分析以及 Java 21 设计模式验证工程。然而随着复习进入深水区，原有基于通用 VitePress 与第三方 `vitepress-plugin-mermaid` 的站点底座显现出若干体验与工程瓶颈：
1. **图表交互能力受限**：下午真题中的大型数据流图 (DFD)、E-R 图与 UML 图元密集，静态 SVG 无法缩放平移与全屏查看，且偶发中文下半部分截断；
2. **缺乏移动与弱网离线支持**：无法在通勤、断网场景下作为原生应用离线刷题；
3. **极客化阅读增强缺失**：缺少快捷命令中心 (`Ctrl+K`)、阅读进度条、字数耗时、超长代码渐变折叠与内链卡片即时预览；
4. **中文专业词汇检索精度不足**：默认分词器对软考专业复合词汇缺乏语义切分；
5. **图形依赖庞大**：引入了 cytoscape、cose-bilkent、elkjs 等多重重量级依赖，拉长依赖解析时间。

为了全面提升备考刷题体验，决定将独立自研的现代全能型知识库底座 `VitePress Zenith`（派生自 `D:\My\dev\vitepress-template`）完整融入本项目，同时坚守“核心备考文档内容 100% 绝对不变”的工程红线。

## 架构决策

1. **图表渲染管线全面切换至 GitHub Primer 规范自研组件**：
   - 彻底卸载 `vitepress-plugin-mermaid`、`cytoscape`、`cytoscape-cose-bilkent`、`elkjs` 等冗余依赖；
   - 接入 Zenith 自研 `<Mermaid>` 交互组件：支持 neutral/dark 主题自适应、纯 SVG 文本居中对齐、滚轮缩放、画布平移拖拽、全屏巨幕查看、错误友好提示及源码一键复制；
   - 引入 `<Markmap>` 思维导图交互组件，支持知识脑图直观呈现。

2. **构建 PWA 渐进式离线应用体系**：
   - 引入 `@vite-pwa/vitepress`，配置 ServiceWorker 与离线预缓存策略；
   - 绑定 GitHub Pages 根路径 `/ruankao-software-designer/`，生成标准化 Web App Manifest；
   - 提供桌面端与移动端一键“安装到主屏幕”能力，保障全脱机环境流畅复习。

3. **全套极客阅读与做题增强组件注入**：
   - **全局快捷命令中心 (`<VpCommandPalette>`)**：`Ctrl+K` 快速检索考点并跳转；
   - **阅读进度与认知指标**：顶部流光阅读进度条 (`<ReadingProgressBar>`) 与字数/耗时评估 (`<DocMeta>`)；
   - **正文插图平滑灯箱 (`medium-zoom`)**：点击平滑缩放检视架构大图；
   - **全键盘极客导航 (`<VpShortcutsModal>`)**：支持 `j`/`k`/`h`/`l`/`?` 全键盘操作；
   - **超长算法代码折叠 (`codeFolding`)**：约束长代码块初始高度，支持渐变展开；
   - **沉浸式专注模式 (`zenMode`)**：顶部感应胶囊与快捷键 `Alt+Z` 一键消除侧栏干扰；
   - **站内内链悬浮预览 (`<VpLinkPreview>`)**：鼠标悬停即时浮层预览关联知识点；
   - **强调色盘选择器 (`<VpThemePicker>`)**：支持自选 6 套高质感备考主题色。

4. **检索体验与样式深度融合**：
   - 引入 `minisearch` 结合原生 `Intl.Segmenter` 对中文字符进行高精度词法切分，大幅提高专业名词命中率；
   - 在 `styles/custom.css` 中完整融合考点表格首列防挤压换行机制与 MathJax 重影防御。

5. **双轨自动化验证契约与类型安全**：
   - 保留 `exam-java` 下 Maven 设计模式单元测试脚本 (`pnpm run test:java`)；
   - 新增 TypeScript 严格类型检查脚本 (`pnpm run typecheck`)；
   - 统一顶层测试聚合接缝：`pnpm run test`（触发 `docs:build` 验证文档 SSG 与 PWA 产物，并串联 `test:java` 验证 Java 单元测试）。

## 预期影响与权衡

- **优势**：
  - 图表查看体验质的飞跃，真题图元解析更清晰直观；
  - 具备全网断网离线刷题能力，适配通勤背诵场景；
  - 依赖体积大幅精简，移除重量级图形计算库，工程现代化程度显著提升；
  - 核心考点文档零变更，平滑无缝升级。
- **权衡与注意点**：
  - 首次构建或离线缓存需拉取静态资源与 ServiceWorker 清单；
  - 需严格保障 GitHub Pages 部署路径基准（`base: '/ruankao-software-designer/'`）与 PWA Manifest 的一致性。
