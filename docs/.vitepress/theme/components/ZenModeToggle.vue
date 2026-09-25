<template>
  <button
    class="zen-mode-toggle"
    :class="{ 'is-active': isZen }"
    :title="isZen ? '还原双侧栏 (快捷键 Alt+Z)' : '收起双侧栏 · 进入宽屏沉浸模式 (快捷键 Alt+Z)'"
    @click="toggleZenMode"
  >
    <span class="icon">{{ isZen ? '📖' : '🖥️' }}</span>
    <span class="text">{{ isZen ? '还原侧栏' : '沉浸全宽' }}</span>
  </button>
</template>

<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue'

const STORAGE_KEY = 'ruankao_zen_mode_state'
const isZen = ref(false)

const applyZenMode = (active: boolean) => {
  isZen.value = active
  if (typeof document !== 'undefined') {
    document.documentElement.classList.remove('is-zen-mode')
    if (active) {
      document.body.classList.add('is-zen-mode')
    } else {
      document.body.classList.remove('is-zen-mode')
    }
  }
}

const toggleZenMode = () => {
  const next = !isZen.value
  applyZenMode(next)
  if (typeof localStorage !== 'undefined') {
    localStorage.setItem(STORAGE_KEY, next ? 'true' : 'false')
  }
}

const handleKeydown = (e: KeyboardEvent) => {
  // 支持 Alt + Z 快捷键快速切换沉浸模式
  if (e.altKey && (e.key === 'z' || e.key === 'Z')) {
    e.preventDefault()
    toggleZenMode()
  }
}

onMounted(() => {
  try {
    const saved = localStorage.getItem(STORAGE_KEY)
    if (saved === 'true') {
      applyZenMode(true)
    }
  } catch {
    // 忽略安全策略限制异常
  }
  window.addEventListener('keydown', handleKeydown)
})

onUnmounted(() => {
  if (typeof window !== 'undefined') {
    window.removeEventListener('keydown', handleKeydown)
  }
})
</script>

<style scoped>
.zen-mode-toggle {
  display: inline-flex;
  align-items: center;
  gap: 5px;
  padding: 3px 10px;
  height: 28px;
  margin-left: 8px;
  font-size: 12px;
  font-weight: 500;
  color: var(--vp-c-text-2);
  background-color: var(--vp-c-bg-alt);
  border: 1px solid var(--vp-c-divider);
  border-radius: 6px;
  cursor: pointer;
  transition: all 0.2s ease;
  user-select: none;
}

.zen-mode-toggle:hover {
  color: var(--vp-c-brand-1);
  border-color: var(--vp-c-brand-1);
  background-color: var(--vp-c-bg-mute);
}

.zen-mode-toggle.is-active {
  color: #fff;
  background-color: var(--vp-c-brand-1);
  border-color: var(--vp-c-brand-1);
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

.zen-mode-toggle .icon {
  font-size: 13px;
  line-height: 1;
}

.zen-mode-toggle .text {
  line-height: 1;
}

/* 屏幕较小时（< 960px 移动端），VitePress 侧栏原本已是抽屉折叠，无需此按钮 */
@media (max-width: 959px) {
  .zen-mode-toggle {
    display: none;
  }
}
</style>
