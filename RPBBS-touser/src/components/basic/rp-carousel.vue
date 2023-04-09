<template lang="">
    <rpImg2big
        v-if="visable"
        @clickit="viewImg"
        :imgSrc="imgSrc"
        class="img-big"
    ></rpImg2big>
<!-- //轮播图组件,可以用按钮切换图片,读取list中的图片 -->
<div class="relative">
    <div class="overflow-hidden">
      <div class="flex transition-all duration-500 ease-in-out" :style="{ transform: `translateX(-${currentSlide * slideWidth}%)` }">
        <div v-for="(slide, index) in props.list" :key="index" class="w-full flex-shrink-0 overflow-hidden xl:h-md md:h-md sm:h-sm cellphone rounded-box bg-black relative">
        <img :src="slide" alt="" class="xl:h-md md:h-md sm:h-sm cellphone w-a m-a"  @click="bigScale(slide)">
        </div>
    </div>
    </div>

    <button @click="prevSlide" class="absolute top-1/2 left-0 transform -translate-y-1/2 px-4 py-2 bg-gray-800 text-white rounded-l-md hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-gray-400 focus:ring-opacity-75">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-6 h-6">
        <path fill-rule="evenodd" d="M9.293 15.707a1 1 0 01-1.414 0l-5-5a1 1 0 010-1.414l5-5a1 1 0 111.414 1.414L5.414 10H17a1 1 0 110 2H5.414l3.293 3.293a1 1 0 010 1.414z" clip-rule="evenodd" />
    </svg>

    </button>

    <button @click="nextSlide" class="absolute top-1/2 right-0 transform -translate-y-1/2 px-4 py-2 bg-gray-800 text-white rounded-r-md hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-gray-400 focus:ring-opacity-75">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-6 h-6">
        <path fill-rule="evenodd" d="M10.707 4.293a1 1 0 011.414 0l5 5a1 1 0 010 1.414l-5 5a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-3.293-3.293a1 1 0 010-1.414z" clip-rule="evenodd" />
    </svg>
    </button>
    
    <div class="absolute bottom-0 left-0 right-0 flex justify-center space-x-2 pb-2">
    <button v-for="(slide, index) in slides" :key="index" @click.prevent="currentSlide = index"
            :class="{ 'bg-gray-800': currentSlide === index, 'bg-gray-400': currentSlide !== index }"
            class="w-[10px] h-[10px] rounded-full transition-all duration-[300ms] ease-in-out"></button>
    </div>
</div>
</template>
<script lang="ts" setup>
import { ref, reactive } from 'vue';
import type { Ref } from 'vue';
import { onMounted } from 'vue'
import rpImg2big from '@/components/basic/rp-img2big.vue';

onMounted(() => {
    pinimg.value = props.list[picCount.value]
});
const currentSlide = ref(0)
const slideWidth: any = ref(100)
const picCount: Ref<number> = ref(0);
const visable: Ref<boolean> = ref(false);
const imgSrc: Ref<string> = ref('');
const pinimg: Ref<string> = ref('');
//获取切换图片的宽度

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

const prevSlide = () => {
    if (currentSlide.value === 0) {
        currentSlide.value = props.list.length - 1
    } else {
        currentSlide.value--
    }
}

const nextSlide = () => {
    if (currentSlide.value === props.list.length - 1) {
        currentSlide.value = 0
    } else {
        currentSlide.value++
    }
}
interface Props {
    list: any,
}
const props = withDefaults(defineProps<Props>(), {
})
</script>
<style lang="less">
@media (max-width: 640px) {

    .cellphone {
        height: 24rem;
    }

}
</style>