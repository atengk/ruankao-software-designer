/**
 * VitePress 站点核心配置 (软考软件设计师备考知识库)
 * 基于 VitePress Zenith 旗舰级架构构建
 * @author Ateng
 * @since 2026-09-29
 */

import { defineConfig } from 'vitepress'
import { withPwa } from '@vite-pwa/vitepress'
import UnoCSS from 'unocss/vite'
import { transformerTwoslash } from '@shikijs/vitepress-twoslash'

const base = process.env.BASE_PATH || '/ruankao-software-designer/'

/**
 * Zenith 旗舰级特性开关矩阵 (Zenith Feature Switches)
 * 遵循极简与渐进式原则，统一管控软考备考场景下的全站特性
 */
const zenithConfig = {
  // 1. 进阶/特定场景特性（默认关闭）
  i18n: false,              // 国际化多语言矩阵：关闭（纯中文备考）
  versionSwitcher: false,   // 多版本管理与归档横幅：关闭
  helpful: false,           // 文档有用度评价：关闭
  zenModeToggle: false,     // 右下角专注模式悬浮球：关闭（顶部悬浮感应胶囊与快捷键 Alt+Z 已完全满足）
  contributors: false,      // 开源贡献者致谢流：关闭
  themePicker: true,        // 顶栏主题强调色盘选择器：开启（支持自选备考强调色）
  banner: false,            // 顶部全宽公告通知横幅：关闭
  pwaStatus: false,         // PWA 安装横幅提示：关闭（静默离线工作）

  // 2. 旗舰阅读与做题体验特性（默认开启）
  commandPalette: true,     // 全局快捷命令中心浮层 (<VpCommandPalette>)：开启
  blog: false,              // 博客系统：关闭（知识库纯粹聚焦于备考体系）
  mediumZoom: true,         // 正文插图平滑点击放大灯箱：开启（优化 DFD/ER/UML 检视）
  readingMetrics: true,     // 阅读认知指标（字数与预计耗时 DocMeta）：开启
  readingProgressBar: true, // 页面顶部流光阅读进度条：开启
  linkPreview: true,        // 站内内链卡片悬浮预览：开启
  keyboardShortcuts: true,  // 全键盘极客导航与速查浮层：开启
  codeFolding: true,        // 超长代码块自适应高度约束与内滚动：开启（优化算法长代码阅读）
  zenMode: true,            // 沉浸式专注阅读模式（顶部感应胶囊/Alt+Z）：开启
}

export default withPwa(defineConfig({
  title: '软考软件设计师',
  description: '2026 年软考中级软件设计师备考知识库与双轨实战工程',
  lang: 'zh-CN',
  base,

  pwa: {
    outDir: '.vitepress/dist',
    registerType: 'autoUpdate',
    includeAssets: ['logo.svg'],
    manifest: {
      id: base,
      name: '软考软件设计师备考知识库',
      short_name: '软考知识库',
      description: '2026 年软考中级软件设计师备考知识库与双轨实战工程',
      theme_color: '#6366f1',
      background_color: '#0f172a',
      display: 'standalone',
      orientation: 'portrait',
      start_url: base,
      scope: base,
      lang: 'zh-CN',
      categories: ['education', 'productivity'],
      icons: [
        {
          src: `${base}logo.svg`,
          sizes: 'any',
          type: 'image/svg+xml',
          purpose: 'any',
        },
        {
          src: `${base}logo.svg`,
          sizes: 'any',
          type: 'image/svg+xml',
          purpose: 'maskable',
        },
      ],
    },
    workbox: {
      globPatterns: ['**/*.{css,js,html,svg,png,ico,txt,woff2}'],
      runtimeCaching: [
        {
          urlPattern: ({ request }) =>
            request.destination === 'style' ||
            request.destination === 'script' ||
            request.destination === 'worker',
          handler: 'StaleWhileRevalidate',
          options: {
            cacheName: 'static-resources',
            expiration: {
              maxEntries: 120,
              maxAgeSeconds: 30 * 24 * 60 * 60,
            },
            cacheableResponse: {
              statuses: [0, 200],
            },
          },
        },
        {
          urlPattern: ({ request }) => request.destination === 'image',
          handler: 'CacheFirst',
          options: {
            cacheName: 'images-cache',
            expiration: {
              maxEntries: 100,
              maxAgeSeconds: 60 * 24 * 60 * 60,
            },
            cacheableResponse: {
              statuses: [0, 200],
            },
          },
        },
        {
          urlPattern: ({ url }) =>
            url.origin === 'https://fonts.googleapis.com' ||
            url.origin === 'https://fonts.gstatic.com',
          handler: 'StaleWhileRevalidate',
          options: {
            cacheName: 'google-fonts',
            expiration: {
              maxEntries: 30,
              maxAgeSeconds: 365 * 24 * 60 * 60,
            },
            cacheableResponse: {
              statuses: [0, 200],
            },
          },
        },
        {
          urlPattern: ({ url }) => url.origin === 'https://cdn.jsdelivr.net',
          handler: 'CacheFirst',
          options: {
            cacheName: 'jsdelivr-cdn',
            expiration: {
              maxEntries: 50,
              maxAgeSeconds: 30 * 24 * 60 * 60,
            },
            cacheableResponse: {
              statuses: [0, 200],
            },
          },
        },
      ],
    },
    experimental: {
      includeAllowlist: true,
    },
  },

  markdown: {
    math: true,
    lineNumbers: true,
    codeTransformers: [
      transformerTwoslash(),
    ],
    config(md) {
      // 1. MathJax <style> 标签去重拦截函数（彻底杜绝内联公式样式重复膨胀）
      const origInline = md.renderer.rules.math_inline;
      if (origInline) {
        md.renderer.rules.math_inline = (tokens, idx, options, env, self) => {
          const raw = origInline(tokens, idx, options, env, self);
          return raw.replace(/<style[\s\S]*?<\/style>/gi, '');
        };
      }
      const origBlock = md.renderer.rules.math_block;
      if (origBlock) {
        md.renderer.rules.math_block = (tokens, idx, options, env, self) => {
          const raw = origBlock(tokens, idx, options, env, self);
          return raw.replace(/<style[\s\S]*?<\/style>/gi, '');
        };
      }

      // 2. 自研 Mermaid 与 Markmap 矢量组件拦截管线
      const defaultFence = md.renderer.rules.fence!
      md.renderer.rules.fence = (tokens, idx, options, env, self) => {
        const token = tokens[idx]
        const lang = token.info.trim().split(/\s+/)[0]
        if (lang === 'mermaid') {
          const key = `mermaid-${idx}`
          const code = encodeURIComponent(token.content)
          return `<Mermaid id="${key}" code="${code}" />\n`
        }
        if (lang === 'markmap') {
          const key = `markmap-${idx}`
          const code = encodeURIComponent(token.content)
          return `<Markmap id="${key}" code="${code}" />\n`
        }
        const rendered = defaultFence(tokens, idx, options, env, self)

        // 修复 VitePress 内置 lineNumberPlugin 在结合 Twoslash 时行号提前截断的缺陷
        const wrapperIdx = rendered.indexOf('<div class="line-numbers-wrapper"')
        if (wrapperIdx !== -1) {
          const matchStartLineNumber = token.info.match(/=(\d+)/)
          const startLineNumber = matchStartLineNumber ? parseInt(matchStartLineNumber[1], 10) : 1
          const codeBeforeWrapper = rendered.slice(0, wrapperIdx)
          const cleanCode = codeBeforeWrapper
            .replace(/<template\s+(?:v-slot:popper|#popper)[\s\S]*?<\/template>/g, '')
            .replace(/<span\s+class="[^"]*twoslash-floating[^"]*"[\s\S]*?<\/span>\s*<\/span>\s*<\/span>/g, '')
          const lineMatches = cleanCode.match(/class="line(?:\s+[^"]*)?"/g)
          const rawLines = token.content.replace(/\r\n/g, '\n').replace(/\n$/, '').split('\n').length
          const lineCount = lineMatches ? lineMatches.length : rawLines

          const lineNumbersCode = Array.from(
            { length: lineCount },
            (_, i) => `<span class="line-number">${i + startLineNumber}</span><br>`
          ).join('')

          return rendered.replace(
            /<div class="line-numbers-wrapper"[^>]*>[\s\S]*?<\/div>/,
            `<div class="line-numbers-wrapper" aria-hidden="true">${lineNumbersCode}</div>`
          )
        }

        return rendered
      }
    },
  },

  head: [
    ['meta', { name: 'theme-color', content: '#6366f1' }],
    ['link', { rel: 'icon', href: `${base}logo.svg` }],
    ['link', { rel: 'apple-touch-icon', href: `${base}logo.svg` }],
    ['meta', { name: 'mobile-web-app-capable', content: 'yes' }],
    ['meta', { name: 'apple-mobile-web-app-capable', content: 'yes' }],
    ['meta', { name: 'apple-mobile-web-app-status-bar-style', content: 'black-translucent' }],
    ['meta', { name: 'apple-mobile-web-app-title', content: '软考知识库' }],
    ['meta', { name: 'keywords', content: '软考, 软件设计师, 中级软考, 计算机体系结构, 操作系统, 数据库, 软件工程, 面向对象, 数据结构, 算法, DFD, UML, 设计模式, Java' }],
    // 防闪烁 (Anti-FOUC) 色盘极速恢复脚本
    ['script', {}, `(function(){try{var p=localStorage.getItem('zenith-theme-palette');if(p&&p!=='indigo'){document.documentElement.dataset.themePalette=p;}}catch(e){}})();`],
  ],

  themeConfig: {
    logo: '🎯',
    siteTitle: '软考软件设计师备考',
    zenith: zenithConfig,

    socialLinks: [
      { icon: 'github', link: 'https://github.com/atengk/ruankao-software-designer' }
    ],

    // 本地全文检索（集成 Intl.Segmenter 高精度中文词法切分）
    search: {
      provider: 'local',
      options: {
        locales: {
          root: {
            translations: {
              button: {
                buttonText: '搜索文档',
                buttonAriaLabel: '搜索文档',
              },
              modal: {
                displayDetails: '显示详细列表',
                resetButtonTitle: '重置搜索',
                backButtonTitle: '关闭搜索',
                noResultsText: '无法找到相关结果',
                footer: {
                  selectText: '选择',
                  selectKeyAriaLabel: '回车键',
                  navigateText: '切换',
                  navigateUpKeyAriaLabel: '向上箭头',
                  navigateDownKeyAriaLabel: '向下箭头',
                  closeText: '关闭',
                  closeKeyAriaLabel: '退出键',
                },
              },
            },
          },
        },
        miniSearch: {
          options: {
            tokenize(text) {
              if (typeof text !== 'string') return []
              if (/[\u4e00-\u9fa5]/.test(text) && typeof Intl !== 'undefined' && Intl.Segmenter) {
                const segmenter = new Intl.Segmenter('zh-CN', { granularity: 'word' })
                const tokens: string[] = []
                for (const { segment } of segmenter.segment(text)) {
                  const s = segment.trim()
                  if (s) tokens.push(s.toLowerCase())
                }
                return tokens
              }
              return text.toLowerCase().split(/[\s,./\\;:'"[\]{}|`~!@#$%^&*()_+\-=?<>]+/).filter(Boolean)
            },
          },
          searchOptions: {
            fuzzy: 0.2,
            prefix: true,
            boost: { title: 4, text: 2, titles: 1 },
          },
        },
      },
    },

    nav: [
      { text: '首页', link: '/' },
      { text: '上午综合知识', link: '/am-general/' },
      { text: '下午应用技术', link: '/pm-application/' },
      { text: '架构决策 (ADR)', link: '/adr/0001-上午题知识库结构与优先攻坚策略' }
    ],

    sidebar: {
      '/pm-application/': [
        {
          text: '下午应用技术概览',
          items: [
            { text: '🎯 通关全景图与及格攻防矩阵', link: '/pm-application/' },
            { text: '📐 万能采分公式与速记手册', link: '/pm-application/answer-templates' },
            { text: '🛡️ 机考上机作答与防坑指南', link: '/pm-application/cbt-guidelines' }
          ]
        },
        {
          text: '试题一：结构化分析与数据流图 (DFD)',
          collapsed: false,
          items: [
            { text: '00 核心法则与异常排查方法论', link: '/pm-application/01-data-flow-diagram/' },
            { text: '01 案例：电商订单与在线支付系统', link: '/pm-application/01-data-flow-diagram/01-case-ecommerce-orders' },
            { text: '02 案例：智慧医院门诊挂号收费系统', link: '/pm-application/01-data-flow-diagram/02-case-hospital-outpatient' },
            { text: '03 案例：智能仓储入出库与物流系统', link: '/pm-application/01-data-flow-diagram/03-case-smart-warehouse' }
          ]
        },
        {
          text: '试题二：数据库系统设计 (E-R与SQL)',
          collapsed: false,
          items: [
            { text: '00 核心铁律与规范化方法论', link: '/pm-application/02-database-design/' },
            { text: '01 案例：高校教务排课与成绩管理系统', link: '/pm-application/02-database-design/01-case-academic-scheduling' },
            { text: '02 案例：智慧物流仓储与配送调度系统', link: '/pm-application/02-database-design/02-case-smart-logistics' },
            { text: '03 案例：连锁超市会员销售与供应链系统', link: '/pm-application/02-database-design/03-case-retail-membership' }
          ]
        },
        {
          text: '试题三：面向对象 UML 系统建模',
          collapsed: false,
          items: [
            { text: '00 核心法则与图元建模方法论', link: '/pm-application/03-uml-modeling/' },
            { text: '01 案例：智能车载导航与驾驶辅助系统', link: '/pm-application/03-uml-modeling/01-case-vehicle-navigation' },
            { text: '02 案例：线上多渠道聚合支付网关系统', link: '/pm-application/03-uml-modeling/02-case-online-payment-gateway' },
            { text: '03 案例：敏捷项目看板与协同研发系统', link: '/pm-application/03-uml-modeling/03-case-agile-kanban-collaboration' }
          ]
        },
        {
          text: '试题四：C 语言算法设计与分析',
          collapsed: false,
          items: [
            { text: '00 战略防守法则与四大宗门识别', link: '/pm-application/04-algorithm-analysis/' },
            { text: '01 动态规划：0-1背包与最长公共子序列', link: '/pm-application/04-algorithm-analysis/01-dynamic-programming-knapsack-lcs' },
            { text: '02 分治与贪心：快速排序与最短路径算法', link: '/pm-application/04-algorithm-analysis/02-divide-conquer-and-greedy' },
            { text: '03 回溯搜索：N 皇后与解空间剪枝模型', link: '/pm-application/04-algorithm-analysis/03-backtracking-n-queens' }
          ]
        },
        {
          text: '试题六：面向对象与设计模式 (Java 选做)',
          collapsed: false,
          items: [
            { text: '试题六：面向对象与设计模式 (Java)', link: '/pm-application/05-design-patterns-java/' }
          ]
        }
      ],
      '/am-general/': [
        {
          text: '上午综合知识概览',
          items: [
            { text: '考情分析与学科导航', link: '/am-general/' },
            { text: '📐 全科计算公式速查手册', link: '/am-general/formula-cheat-sheet' },
            { text: '🛡️ 全科高频避坑与秒杀模板库', link: '/am-general/exam-pitfalls-and-short-cuts' }
          ]
        },
        {
          text: '01 计算机体系结构',
          collapsed: false,
          items: [
            { text: '学科导航', link: '/am-general/01-computer-architecture/' },
            { text: '01 CPU体系结构与CISC/RISC对比', link: '/am-general/01-computer-architecture/01-CPU体系结构微架构与CISC-RISC对比' },
            { text: '02 流水线技术核心公式与计算', link: '/am-general/01-computer-architecture/02-流水线技术核心公式与性能指标计算' },
            { text: '03 Cache层次化存储与海明校验码', link: '/am-general/01-computer-architecture/03-层次化存储体系Cache与海明校验码' }
          ]
        },
        {
          text: '02 操作系统原理',
          collapsed: false,
          items: [
            { text: '学科导航', link: '/am-general/02-operating-system/' },
            { text: '01 进程管理前趋图与PV操作', link: '/am-general/02-operating-system/01-进程管理前趋图与PV操作死锁避免' },
            { text: '02 存储管理分页分段与置换算法', link: '/am-general/02-operating-system/02-存储管理分页分段与页面置换算法' },
            { text: '03 文件索引结构与磁盘寻道算法', link: '/am-general/02-operating-system/03-文件管理索引结构与磁盘寻道算法' }
          ]
        },
        {
          text: '03 软件工程与敏捷',
          collapsed: false,
          items: [
            { text: '学科导航', link: '/am-general/03-software-engineering/' },
            { text: '01 开发模型与敏捷方法辨析', link: '/am-general/03-software-engineering/01-软件开发模型与敏捷方法辨析' },
            { text: '02 需求工程与数据流图DFD', link: '/am-general/03-software-engineering/02-需求工程与结构化分析DFD' },
            { text: '03 软件测试与McCabe环路复杂度', link: '/am-general/03-software-engineering/03-软件测试技术与McCabe环路复杂度计算' },
            { text: '04 项目管理与进度网络图分析', link: '/am-general/03-software-engineering/04-软件项目管理与进度网络图分析' }
          ]
        },
        {
          text: '04 面向对象与设计模式',
          collapsed: false,
          items: [
            { text: '学科导航', link: '/am-general/04-object-oriented-design/' },
            { text: '01 面向对象概念与SOLID原则', link: '/am-general/04-object-oriented-design/01-面向对象基本概念与设计原则' },
            { text: '02 UML核心图谱与关系辨析', link: '/am-general/04-object-oriented-design/02-UML核心图谱与关系辨析' },
            { text: '03 GoF 23种设计模式全景矩阵', link: '/am-general/04-object-oriented-design/03-GoF23种设计模式全景分类与辨析矩阵' }
          ]
        },
        {
          text: '05 数据库系统',
          collapsed: false,
          items: [
            { text: '学科导航', link: '/am-general/05-database-system/' },
            { text: '01 E-R向关系模式转换与关系代数', link: '/am-general/05-database-system/01-ER模型向关系模式转换与关系代数' },
            { text: '02 规范化理论函数依赖与范式判定', link: '/am-general/05-database-system/02-规范化理论函数依赖与范式判定' },
            { text: '03 事务ACID与并发控制封锁协议', link: '/am-general/05-database-system/03-事务ACID特性与并发控制封锁协议' }
          ]
        },
        {
          text: '06 数据结构与算法基础',
          collapsed: false,
          items: [
            { text: '学科导航', link: '/am-general/06-data-structures-algorithms/' },
            { text: '01 树与二叉树性质与哈夫曼树', link: '/am-general/06-data-structures-algorithms/01-树与二叉树核心性质与哈夫曼树' },
            { text: '02 图的遍历与最小生成树拓扑排序', link: '/am-general/06-data-structures-algorithms/02-图的存储遍历与最小生成树拓扑排序' },
            { text: '03 查找与内部排序算法时空复杂度', link: '/am-general/06-data-structures-algorithms/03-查找与内部排序算法时空复杂度全景矩阵' }
          ]
        },
        {
          text: '07 计算机网络与网络安全',
          collapsed: false,
          items: [
            { text: '学科导航', link: '/am-general/07-network-and-security/' },
            { text: '01 OSI七层模型与TCP/IP协议端口', link: '/am-general/07-network-and-security/01-OSI七层模型与TCPIP协议栈协议端口' },
            { text: '02 IP地址规划子网划分与CIDR聚合', link: '/am-general/07-network-and-security/02-IP地址规划子网划分与CIDR路由聚合' },
            { text: '03 加解密算法数字签名与数字信封', link: '/am-general/07-network-and-security/03-网络安全加解密算法数字签名与数字信封' }
          ]
        },
        {
          text: '08 法律法规与标准化',
          collapsed: false,
          items: [
            { text: '学科导航', link: '/am-general/08-ip-and-standards/' },
            { text: '01 软件著作权归属与侵权判定', link: '/am-general/08-ip-and-standards/01-软件著作权归属与侵权判定' },
            { text: '02 专利商标保护期与标准化代号', link: '/am-general/08-ip-and-standards/02-专利权商标权保护期限与标准化代号' }
          ]
        },
        {
          text: '09 计算机专业英语',
          collapsed: false,
          items: [
            { text: '学科导航', link: '/am-general/09-english/' },
            { text: '01 专业英语核心词汇与解题技巧', link: '/am-general/09-english/01-计算机专业英语核心词汇库与解题技巧' }
          ]
        }
      ],
      '/adr/': [
        {
          text: '架构决策记录 (ADR)',
          items: [
            { text: '0001 上午题知识库结构与优先攻坚策略', link: '/adr/0001-上午题知识库结构与优先攻坚策略' },
            { text: '0002 面向对象实战验证语言选型 (Java)', link: '/adr/0002-面向对象实战验证语言选型Java' },
            { text: '0003 上午题知识库完善与题库构建策略', link: '/adr/0003-上午题知识库完善与题库构建策略' },
            { text: '0004 VitePress集成与全站文档目录收敛规范', link: '/adr/0004-VitePress集成与文档目录收敛规范' },
            { text: '0005 任务跟踪器迁移至GitHub Issues', link: '/adr/0005-任务跟踪器迁移至GitHub-Issues' },
            { text: '0006 上午题排版视觉规范与检索式自测交互演进', link: '/adr/0006-上午题排版视觉规范与检索式自测交互演进' },
            { text: '0007 下午应用技术知识库架构与Java实战工程规范', link: '/adr/0007-下午应用技术知识库架构与Java实战工程规范' },
            { text: '0008 知识库工程底座升级迁移至VitePress-Zenith旗舰架构', link: '/adr/0008-知识库工程底座升级迁移至VitePress-Zenith旗舰架构' }
          ]
        }
      ]
    },

    footer: {
      message: '全国计算机技术与软件专业技术资格（水平）考试 · 软件设计师（中级）',
      copyright: '版权所有 © 2026 Ateng. 基于 VitePress 构建.'
    },
    docFooter: {
      prev: '上一篇',
      next: '下一篇'
    },
    outline: {
      level: [2, 3],
      label: '本页导读'
    }
  },

  vite: {
    plugins: [
      UnoCSS(),
    ],
  },
}))
