<template>
    <div class="flex h-full">
        <Sidebar class="hidden-sider"></Sidebar>
        <router-view class="min-w-sm content"></router-view>
        <Rightbar class="hidden-Rightbar"></Rightbar>
    </div>
</template>
    
<script setup lang='ts'>
import { ref, reactive } from 'vue'
import Content from './content/index.vue'
import Sidebar from './Sidebar/index.vue'
import Rightbar from './Rightbar/index.vue'
</script>
    
<style lang='less' scoped>
@media (max-width: 1150px) {

    .hidden-sider {

        display: none;

    }


}
@media  (min-width: 960px) {
    .content {

width: 56rem;

}
}
@media (max-width: 1280px) {

.hidden-Rightbar {

    display: none;

}

}
</style>