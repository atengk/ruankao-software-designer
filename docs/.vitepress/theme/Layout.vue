<template>
  <Layout>
    <template #nav-bar-content-after>
      <ZenModeToggle />
    </template>
  </Layout>
</template>

<script setup lang="ts">
import DefaultTheme from 'vitepress/theme'
import ZenModeToggle from './components/ZenModeToggle.vue'

const { Layout } = DefaultTheme
</script>
