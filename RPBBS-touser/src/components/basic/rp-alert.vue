<template>
    <div class="flex justify-center items-center">
        <transition name="fade">
            <div v-if="visible" class="fixed mt20 top-0 left-0 w-full flex justify-center items-center">
                <div>
                    <div :class="'alert alert-' + type" @click.self="hideAlert">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                            class="stroke-current flex-shrink-0 w-6 h-6">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                        </svg>
                        <span> {{ message }}</span>
                    </div>
                </div>
            </div>
        </transition>
    </div>
</template>

<script setup lang="ts">
import { ref } from "vue";

const visible = ref(false);
const message = ref("");
const type = ref("");

const showAlert = (msg: string, t: string) => {
    message.value = msg;
    type.value = t;
    visible.value = true;
    setTimeout(() => {
        hideAlert();
    }, 3000);
};

const hideAlert = () => {
    visible.value = false;
};

defineExpose({
    showAlert,
});
</script>

<style lang="less" scope>
.fade-enter-active,
.fade-leave-active {
    transition: opacity 1s;
}

.fade-enter-from,
.fade-leave-to {
    opacity: 0;
}
</style>