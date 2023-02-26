<template lang="">
    <rpImg2big
        v-if="visable"
        @clickit="viewImg"
        :imgSrc="imgSrc"
        class="img-big"
    ></rpImg2big>
    <!-- 图片小于等于三时 -->
    <div class="overflow-hidden h-32 mx-6 w-sm rounded-box relative flex " v-if='props.list.length <= 3'>
        <div class=" h-full w-30% mx-1 bg-black rounded-box relative overflow-hidden my-1" v-for="item in props.list">
            <img  class="absolute top-0 bottom-0 m-a" :src="item" @click="bigScale(item)" alt="" >
        </div>
    </div>
    <!-- 图片大于三时 -->
    <div class="overflow-hidden h-32 mx-6 w-sm rounded-box relative flex" v-if='props.list.length>3'>
        <div class=" h-full sm:w-30% min-w-25% mx-1 bg-black rounded-box relative overflow-hidden my-1">
            <img  class="absolute top-0 bottom-0 m-a" :src="props.list[0]" @click="bigScale(props.list[0])" alt="" >
        </div>
        <div class=" h-full sm:w-30% min-w-25% mx-1 bg-black rounded-box relative overflow-hidden my-1">
            <img  class="absolute top-0 bottom-0 m-a" :src="props.list[1]" @click="bigScale(props.list[1])" alt="" >
        </div>
        <div class=" h-full sm:w-30% min-w-25% mx-1 bg-#666666 rounded-box relative overflow-hidden my-1">
            <div class="title items-center flex text-4xl h-100% w-50% m-a cellphone">+{{props.list.length-2}}</div>
        </div>
    </div>
</template>
<script lang="ts" setup>
import { ref, reactive } from 'vue';
import type { Ref } from 'vue';
import { onMounted } from 'vue'
import rpImg2big from '@/components/basic/rp-img2big.vue';

const picCount: Ref<number> = ref(0);
const visable: Ref<boolean> = ref(false);
const imgSrc: Ref<string> = ref('');
const pinimg: Ref<string> = ref('');

function showpic() {
    visable.value = !visable.value;
    console.log(`output-visable`, visable)
};
function viewImg() {
    visable.value = false;
};
function bigScale(item: string) {
    imgSrc.value = item
    visable.value = true;

};

interface Props {
    list: Array<string>,
}
const props = withDefaults(defineProps<Props>(), {
})
</script>
<style lang="less">
</style>