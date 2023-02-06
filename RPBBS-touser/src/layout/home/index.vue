<template>
        <div class="flex h-full">
            <Sidebar></Sidebar>
            <Content></Content>
            <Rightbar></Rightbar>
        </div>
</template>
    
<script setup lang='ts'>
import { ref, reactive } from 'vue'
import Content from './content/index.vue'
import Sidebar from './Sidebar/index.vue'
import Rightbar from './Rightbar/index.vue'
</script>
    
<style scoped lang='less'>
::-webkit-scrollbar {
    width: 5px;
    height: 5px;
}

::-webkit-scrollbar-thumb {
    background: linear-gradient(13deg, #180909 14%, #837a81 64%);
    border-radius: 10px;
}

::-webkit-scrollbar-thumb:hover {
    background: linear-gradient(13deg, #000000 14%, #737174 64%);
}

::-webkit-scrollbar-track {
    background: #ffffff;
    border-radius: 10px;
    box-shadow: inset 7px 10px 12px #f0f0f0;
}
</style>