<template lang="">
    <rpImg2big
        v-if="visable"
        @clickit="viewImg"
        :imgSrc="imgSrc"
        class="img-big"
    ></rpImg2big>
    <div class="overflow-hidden xl:h-md md:h-md sm:h-sm cellphone mx-8 rounded-box bg-black relative">
            <img :src="pinimg" class="xl:h-md md:h-md sm:h-sm cellphone w-a m-a" alt="item" @click="bigScale(pinimg)"/>
            <!-- <img v-for="item in props.list" class="xl:h-md md:h-md sm:h-sm cellphone w-a m-a" :src="item" alt=""> -->
            <!-- <div class="carousel carousel-center">
                <div id='carousel-item' class="carousel-item w-full bg-black mx-a" v-for="(item,index) in props.list">
                    <img :src="item" class="xl:h-md md:h-md sm:h-sm cellphone w-a m-a" alt="item" @click="bigScale(item)"/>
                </div> 
            </div> -->
        <div class="absolute flex justify-between transform -translate-y-1/2 left-5 right-5 top-1/2">
            <a  class="btn btn-circle" @click='leftchange()'>❮</a> 
            <a  class="btn btn-circle" @click='rightchange()'>❯</a>
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
const picCount: Ref<number> = ref(0);
const visable: Ref<boolean> = ref(false);
const imgSrc: Ref<string> = ref('');
const pinimg: Ref<string> = ref('');
function leftchange() {
    if (picCount.value != 0) {
        picCount.value--
        pinimg.value = props.list[picCount.value]
    } else {
        pinimg.value = props.list[props.list.length - 1]
        picCount.value = props.list.length - 1
    }
};
function rightchange() {
    if (picCount.value != props.list.length - 1) {
        picCount.value++
        pinimg.value = props.list[picCount.value]
    } else {
        pinimg.value = props.list[0]
        picCount.value = 0
    }


};
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
        height: 24rem;
    }

}
</style>