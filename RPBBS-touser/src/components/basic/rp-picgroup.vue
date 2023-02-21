<template lang="">
    <rpImg2big
        v-if="visable"
        @clickit="viewImg"
        :imgSrc="imgSrc"
        class="img-big"
    ></rpImg2big>
    <div class="overflow-hidden h-40vh mx-6 w-40vh rounded-box relative flex flex-wrap" v-if='props.list.length == 3'>
        <div class=" h-45% w-45% mx-1 bg-black rounded-box relative overflow-hidden my-1" v-for="item in props.list">
            <img  class="absolute top-0 bottom-0 m-a" :src="item" @click="bigScale(item)" alt="" >
        </div>
    </div>
    <div class="overflow-hidden h-40vh mx-6 w-40vh rounded-box relative flex flex-wrap" v-if='props.list.length == 4'>
        <div class=" h-45% w-45% m-a bg-black rounded-box relative overflow-hidden my-1" v-for="item in props.list">
            <img  class="absolute top-0 bottom-0 m-a" :src="item" @click="bigScale(item)" alt="" >
        </div>
    </div>
    <div class="overflow-hidden h-40vh mx-6 w-40vh rounded-box relative flex flex-wrap" v-if='props.list.length>4'>
        <div class=" h-45% w-45% m-a bg-black rounded-box relative overflow-hidden my-1">
            <img  class="absolute top-0 bottom-0 m-a" :src="props.list[0]" @click="bigScale(props.list[0])" alt="" >
        </div>
        <div class=" h-45% w-45% m-a bg-black rounded-box relative overflow-hidden my-1">
            <img  class="absolute top-0 bottom-0 m-a" :src="props.list[1]" @click="bigScale(props.list[1])" alt="" >
        </div>
        <div class=" h-45% w-45% m-a bg-black rounded-box relative overflow-hidden my-1">
            <img  class="absolute top-0 bottom-0 m-a" :src="props.list[2]" @click="bigScale(props.list[2])" alt="" >
        </div>
        <div class=" h-45% w-45% m-a bg-black rounded-box relative overflow-hidden my-1">
            <div class="title items-center sm:text-6xl xl:text-20 flex h-100% w-50% m-a cellphone">+{{props.list.length-3}}</div>
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
@media (max-width: 640px) {

.cellphone {
    font-size: 50px;
}

}
</style>