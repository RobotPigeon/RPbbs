<template>
    <router-view></router-view>
</template>

<script setup lang='ts'>
import { ref, reactive } from 'vue'
import { onMounted } from 'vue'
import { themeChange } from "theme-change";
onMounted(() => {
    setTimeout(() => {
        themeChange(false)
    }, 1)
    themeChange(true)
})
console.log(import.meta.env.VITE_API)
</script>

<style scoped lang='less'></style>