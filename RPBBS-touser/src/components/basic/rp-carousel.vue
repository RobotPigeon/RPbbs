<template lang="">
            <div class="carousel carousel-center h-a" v-show="visable">
                <div class="carousel-item w-full bg-black mx-a" v-for="(item,index) in props.list">
                    <img :src="item" class="w-a h-a mx-a" alt="item" />
                </div> 
            </div>
            <button class="btn" @click="showpic()">展示图片</button>
</template>
<script lang="ts" setup>
import { ref, reactive } from 'vue';
import type { Ref } from 'vue';

const visable: Ref<boolean> = ref(false);

function showpic(){
    visable.value = !visable.value;
    console.log(`output-visable`,visable)
};
interface Props {
    list?: object,
}
const props = withDefaults(defineProps<Props>(), {
    list: () => {
        return [
            'https://lain.bgm.tv/r/400/pic/cover/l/a4/16/296739_71dLe.jpg', 'https://lain.bgm.tv/r/400/pic/cover/l/85/aa/268279_9rynK.jpg'
        ]
    }
})
</script>
<style lang="">
    
</style>