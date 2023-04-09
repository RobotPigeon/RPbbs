<template>
    <router-view></router-view>
    <rp-alert ref="alert" />
</template>

<script setup lang='ts'>
import { ref, reactive, watch } from 'vue'
import { onMounted } from 'vue'
import { themeChange } from "theme-change";
import { createPinia } from 'pinia';
import { provide } from "vue";
import rpAlert from './components/basic/rp-alert.vue';
import useAlertStore from './stores/alert';
onMounted(() => {
    setTimeout(() => {
        themeChange(false)
        console.log(alert);
    }, 1)
    themeChange(true)

})

const pinia = createPinia();
// 使用pinia

// 定义一个ref来获取Alert组件的实例
const alert = ref();

// 提供一个showAlert方法
const showAlert = (message: string, type: string) => {
    // 调用Alert组件的showAlert方法
    alert.value.showAlert(message, type);
};

// 获取alert store
// 监听store中的alert变化

watch(() => useAlertStore().alert, (newVal: any) => {
    // 如果有新的alert，就调用showAlert方法
    if (newVal) {
        showAlert(newVal.message, newVal.type);
    }
});


console.log(import.meta.env.VITE_API)
</script>

<style lang='less'>
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
</style>