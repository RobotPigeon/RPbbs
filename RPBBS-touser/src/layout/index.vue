<template>
    <div class="flex h-screen">
        <div class="flex-1 flex flex-col overflow-hidden">
            <Header class="z-50 shadow-2xl"></Header>
            <router-view></router-view>
        </div>
    </div>
</template>
    
<script setup lang='ts'>
import Header from '../view/home/header/index.vue'
import { ref, reactive } from 'vue'
</script>
    
<style scoped lang='less'>

</style>