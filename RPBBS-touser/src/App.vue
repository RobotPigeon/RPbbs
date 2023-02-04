<template>
<div class="flex h-screen bg-green-300">
  <div class="flex-1 flex flex-col overflow-hidden">
    <Header></Header>
    <router-view></router-view>
  </div>
</div>
</template>

<script setup lang='ts'>
import { ref, reactive } from 'vue'
import Header from '../src/layout/header/index.vue'
console.log(import.meta.env.VITE_API)
</script>

<style scoped lang='less'>

</style>