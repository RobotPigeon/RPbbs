<template>
    <div class="flex h-full">
        <Sidebar class="hidden-sider"></Sidebar>
        <Content class="max-w-3xl min-w-sm"></Content>
        <Rightbar class="hidden-Rightbar"></Rightbar>
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
    background: linear-gradient(13deg, #180909 14%, #070607 64%);
    border-radius: 10px;
}

::-webkit-scrollbar-thumb:hover {
    background: linear-gradient(13deg, #3a3a3a 14%, #3a3a3a 64%);
}

::-webkit-scrollbar-track {
    background: #ffffff;
    border-radius: 10px;
    box-shadow: inset 7px 10px 12px #f0f0f0;
}

@media (max-width: 1024px) {

    .hidden-sider {

        display: none;

    }

}
@media (max-width: 1280px) {

.hidden-Rightbar {

    display: none;

}

}
</style>