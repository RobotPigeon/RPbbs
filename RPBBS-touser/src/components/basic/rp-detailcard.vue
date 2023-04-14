<template>
    <div class="flex w-full h-a items-center justify-center pb-4 bg-base-100">
        <div class="card w-full h-100% bg-base-100 b-1">
            <div class="card-body h-a">
                <div class=" flex justify-start">
                    <label class="btn btn-ghost btn-circle avatar">
                        <div class="w-10 rounded-full">
                            <img v-if="props.useravatar!=''" :src="props.useravatar" alt='avatar' />
                            <img v-else src="@/assets/images/avatar.jpg" alt="">
                        </div>
                    </label>
                    <div class="mt--2 ml-2">
                        <span class="badge badge-accent badge-outline">lv-{{ props.rank }}</span>
                        <span class="card-title">{{ props.username }}</span>
                    </div>
                </div>
                <h2 class="card-title pt4 text-3xl">{{ props.title }}</h2>
                <div v-html="props.richtext"></div>
                <div class="badge badge-lg">{{ props.block }}</div>
            </div>
            <rp-carousel :list="props.piclist"></rp-carousel>
        </div>

    </div>
</template>
<script lang="ts" setup>
import rpCarousel from '@/components/basic/rp-carousel.vue';
import rpPicgroup from '@/components/basic/rp-picgroup.vue';

import { ref, reactive } from 'vue';
import type { Ref } from 'vue';

const imgSrc: Ref<string> = ref('');

const emit = defineEmits(['clickit'])

const bigImg = () => {
    emit('clickit')
}



interface Props {
    title: string
    piclist?: Array<string>
    username: string
    useravatar: string
    richtext: string
    block: string
    rank: number
}
const props = withDefaults(defineProps<Props>(), {
})

</script>
<style lang="less">
@media (max-width: 640px) {

    .hiddenstat {
        display: none;
    }

}
</style>
