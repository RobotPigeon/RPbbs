<template>
    <div class="Big_image">
        <!-- 过渡动画 -->
        <transition name="fade">
            <div class="position-inherit w-full h-full" @click="bigImg">
                <!-- 遮罩层 -->
                <div class="mask position-fixed z-999 top-0 left-0 w-full h-full overflow-hidden"></div>
                <div class="max-w-full display-block position-fixed  top-50% left-50% transform z1000">
                    <img class="min-w-sm min-h-sm" :src="props.imgSrc">
                </div>
            </div>
        </transition>
    </div>
</template>
<script lang="ts" setup>
import { ref, reactive } from 'vue';
import type { Ref } from 'vue';

const imgWidth: Ref<string> = ref('100%');
const imgHeight: Ref<string> = ref('100%');
const imgSrc: Ref<string> = ref('');

const emit = defineEmits(['clickit'])

const bigImg = () => {
    emit('clickit')
}


interface Props {
    imgSrc?: string
}
const props = withDefaults(defineProps<Props>(), {
})
</script>
<style lang="less" scoped>
.mask{
    background-color:rgba(184, 178, 178, 0.9);
}
.transform {
    transform: translate(-50%, -50%);
}

.Big_image {

    .Big_image>.fade-enter-active,
    .Big_image.fade-leave-active {
        transition: all 1s;
        transform: translate3d(0, 0, 0);
    }

    .fade-enter,
    .fade-leave-active {
        transform: translate3d(100%, 0, 0);
    }
}
</style>