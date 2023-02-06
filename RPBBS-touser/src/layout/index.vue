<template>
    <div class="flex h-screen bg-green-300">
        <div class="flex-1 flex flex-col overflow-hidden">
            <Header></Header>
            <router-view></router-view>
        </div>
    </div>
</template>
    
<script setup lang='ts'>
import Header from './home/header/index.vue'
import { ref, reactive } from 'vue'
</script>
    
<style scoped lang='less'>
::-webkit-scrollbar {
    width: 5px;
    height: 5px;
}

::-webkit-scrollbar-thumb {
    background: linear-gradient(13deg, #7bcfeb 14%, #e685d3 64%);
    border-radius: 10px;
}

::-webkit-scrollbar-thumb:hover {
    background: linear-gradient(13deg, #c7ceff 14%, #f9d4ff 64%);
}

::-webkit-scrollbar-track {
    background: #ffffff;
    border-radius: 10px;
    box-shadow: inset 7px 10px 12px #f0f0f0;
}
</style>