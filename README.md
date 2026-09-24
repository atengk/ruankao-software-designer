# 软考软件设计师（中级）系统化备考工程与知识库

<p align="center">
  <a href="https://atengk.github.io/ruankao-software-designer/">
    <img src="https://img.shields.io/badge/在线阅读-GitHub%20Pages-42b883?style=for-the-badge&logo=vitepress&logoColor=white" alt="在线阅读">
  </a>
  <a href="https://github.com/atengk/ruankao-software-designer/actions/workflows/deploy.yml">
    <img src="https://img.shields.io/github/actions/workflow/status/atengk/ruankao-software-designer/deploy.yml?branch=main&label=%E9%A1%B5%E9%9D%A2%E6%9E%84%E5%BB%BA&style=for-the-badge" alt="页面构建状态">
  </a>
  <img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21">
  <img src="https://img.shields.io/badge/VitePress-1.6.4-646CFF?style=for-the-badge&logo=vite&logoColor=white" alt="VitePress">
  <img src="https://img.shields.io/badge/目标考季-2026%E5%B9%B4%E4%B8%8B%E5%8D%8A%E5%B9%B4-blue?style=for-the-badge" alt="目标考季">
</p>

本项目面向全国计算机技术与软件专业技术资格（水平）考试 —— **软件设计师（中级）** 的全流程工程化备考。涵盖**上午综合知识（75分）**全部 9 大考纲学科的四要素考点精要、历年真题逐项排错题库、高频数值计算公式速查手册，以及**下午应用技术（75分）**面向对象设计模式的 Java 21 可运行代码实操双轨验证。

📖 **官方在线知识门户**：[https://atengk.github.io/ruankao-software-designer/](https://atengk.github.io/ruankao-software-designer/)

---

## 一、 项目四大核心工程特色

```
                                ┌── 1. 核心考纲与大纲定义
                                ├── 2. 计算公式与分析模型
    ┌── 【四要素闭环考点精要】 ──┤
    │                           ├── 3. 命题题眼与陷阱防御
    │                           └── 4. 典型真题逐项排错解析 (Distractor Analysis)
    │
备考体系
    │                           ┌── 算法与数据结构 ─── 贯通下午题四（C语言算法）
    ├── 【上下午强贯通高投产比】─┼── 软件工程与DFD ──── 贯通下午题一（数据流图）
    │                           ├── 数据库系统 ─────── 贯通下午题二（E-R模型/SQL）
    │                           └── 面向对象与模式 ─── 贯通下午题三(UML)与题六(Java)
    │
    └── 【Java 21 双轨实战验证】── 拒绝纸上谈兵，对 GoF 23 种设计模式落地 JUnit 5 单元测试
```

1. **四要素闭环考点精要**：
   彻底杜绝散装笔记。每个考点精要严格闭环包含：**核心考纲大纲**、**公式与分析模型**、**命题陷阱防御**以及**典型真题切入验证**。
2. **逐项排错题库 (Distractor Analysis)**：
   严禁“单纯给个答案”式的低效刷题。对每道嵌入真题的 A、B、C、D 选项展开全量剖析，详述干扰项错误机理、混淆点与反例。
3. **上下午知识深度贯通（投产比最大化）**：
   精准锁定面向对象与设计模式（~27分）、软件工程与数据流图（~25分）、数据库系统（~22分）、数据结构与算法（~25分）五大贯通盘，学一次拿下两头分值。
4. **Java 21 双轨代码验证**：
   在 `src/` 中搭建标准 Maven / JUnit 5 测试工程，将下午试题高频出现的策略模式、观察者模式、装饰器模式等转化为可运行测试用例，从根本上杜绝下午机考代码填空的语法手生。

---

## 二、 知识库全景导航与学科索引

### 上午综合知识学科模块（全域 100% 覆盖）

| 模块编码 | 学科专题 | 重点覆盖范围 | 历年分值 | 贯通下午 | 在线直达链接 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **MOD-04** | **面向对象技术与设计模式** | SOLID原则、UML核心图谱、GoF 23种设计模式辨析 | **10~14分** | **强贯通** (下午题3+题6) | [查看精要](https://atengk.github.io/ruankao-software-designer/am-general/04-object-oriented-design/) |
| **MOD-03** | **软件工程基础与敏捷** | 生命周期模型、敏捷Scrum/看板、McCabe环路复杂度、PERT网络 | **8~12分** | **强贯通** (下午题1) | [查看精要](https://atengk.github.io/ruankao-software-designer/am-general/03-software-engineering/) |
| **MOD-06** | **数据结构与算法基础** | 树与哈夫曼树、图遍历/最小生成树、查找与排序时空复杂度全矩阵 | **8~12分** | **强贯通** (下午题4) | [查看精要](https://atengk.github.io/ruankao-software-designer/am-general/06-data-structures-algorithms/) |
| **MOD-02** | **操作系统原理** | 前趋图与PV操作死锁避免、分页分段置换算法、文件多级索引 | **6~8分** | 弱贯通 | [查看精要](https://atengk.github.io/ruankao-software-designer/am-general/02-operating-system/) |
| **MOD-05** | **数据库系统** | E-R向关系模式转换、函数依赖与范式判定(1NF~BCNF)、事务ACID与封锁 | **6~8分** | **强贯通** (下午题2) | [查看精要](https://atengk.github.io/ruankao-software-designer/am-general/05-database-system/) |
| **MOD-01** | **计算机硬件体系结构** | CPU寄存器职责、流水线吞吐率与加速比、Cache映射、海明校验码 | **4~6分** | 弱贯通 | [查看精要](https://atengk.github.io/ruankao-software-designer/am-general/01-computer-architecture/) |
| **MOD-07** | **网络与信息安全** | OSI与TCP/IP协议端口、子网划分与CIDR、加解密算法与数字信封 | **8~10分** | 弱贯通 | [查看精要](https://atengk.github.io/ruankao-software-designer/am-general/07-network-and-security/) |
| **MOD-08** | **法律法规与标准化** | 软件著作权归属与侵权判定、专利商标保护期、标准代号速记 | **2~4分** | 无 | [查看精要](https://atengk.github.io/ruankao-software-designer/am-general/08-ip-and-standards/) |
| **MOD-09** | **计算机专业英语** | 高频 100+ 专业词汇矩阵、语境语法解题技巧 | **5分** | 无 | [查看精要](https://atengk.github.io/ruankao-software-designer/am-general/09-english/) |

---

## 三、 工程架构决策记录 (ADR)

本项目的所有重大架构设计与技术选型均沉淀为架构决策记录（ADR）：

- [ADR 0001: 上午题知识库结构与优先攻坚策略](./docs/adr/0001-上午题知识库结构与优先攻坚策略.md)
- [ADR 0002: 面向对象实战验证语言选型 (Java)](./docs/adr/0002-面向对象实战验证语言选型Java.md)
- [ADR 0003: 上午题知识库完善与题库构建策略](./docs/adr/0003-上午题知识库完善与题库构建策略.md)
- [ADR 0004: VitePress 集成与全站文档目录收敛规范](./docs/adr/0004-VitePress集成与文档目录收敛规范.md)

---

## 四、 本地开发与构建预览指南

本项目基于 **Node.js (>= 20)** 与 **pnpm** 构建。

```bash
# 1. 克隆代码仓库
git clone https://github.com/atengk/ruankao-software-designer.git
cd ruankao-software-designer

# 2. 安装项目依赖
pnpm install

# 3. 启动本地 VitePress 开发服务器（支持热热载）
pnpm run docs:dev

# 4. 执行生产环境静态站点构建
pnpm run docs:build

# 5. 本地预览打包产物
pnpm run docs:preview
```

---

## 五、 自动化持续交付流水线

本项目已配置基于 GitHub Actions 的全自动化 CI/CD 流水线（`.github/workflows/deploy.yml`）：
- **自动触发**：当代码推送至 `main` 分支时自动触发；
- **构建环境**：Ubuntu + Node.js 22 + pnpm 11；
- **全自动发布**：自动校验 Markdown 死链、编译 MathJax 公式并部署上线至 GitHub Pages，全程零人工干预。

---

## 六、 许可与致谢

本项目文档与知识库内容遵循 [MIT 开源许可证](./LICENSE)（或按知识共享协议组织）。

> 祝愿所有备考 2026 年软件设计师资格考试的考生顺利跨过 45 分国家线，一战通过！🎉
