<template>
        <div class="flex h-full">
            <Sidebar></Sidebar>
            <Content class="min-w-max"></Content>
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