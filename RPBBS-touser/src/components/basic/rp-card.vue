<template>
    <div class="flex w-full h-a items-center justify-center pb-4">
        <div class="card w-full h-100% bg-base-100 b-1">
            <div class="card-body h-a">
                <div class=" flex justify-start">
                    <label class="btn btn-ghost btn-circle avatar">
                        <div class="w-10 rounded-full">
                            <img :src="props.useravatar" alt='avatar' />
                        </div>
                    </label>
                    <div class="mt--2 ml-2">
                        <span class="badge badge-accent badge-outline">lv-{{ props.rank }}</span>
                        <span class="card-title">{{ props.username }}</span>
                    </div>
                </div>
                <h2 class="card-title">{{ props.title }}</h2>
                <div v-html="props.richtext"></div>
            </div>
            <rpCarousel :list="props.piclist"></rpCarousel>
            <div class="divider px-8"></div>
            <div class="stats stats-vertical lg:stats-horizontal px-8 pb-4">
                <div class="stats">

                    <div class=" text-center flex justify-around items-center">
                        <label class="swap">
                            <!-- this hidden checkbox controls the state -->
                            <input type="checkbox" @click="handlelike()" />

                            <!-- volume on icon -->
                            <svg t="1676884827500" class="swap-off fill-current" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="1935" width="36" height="36">
                                <path
                                    d="M171.712 571.648l0.352 0.32 287.904 252.8a64 64 0 0 0 82.912 1.344l296.832-244.544a215.584 215.584 0 1 0-301.824-300.576L512 316.672l-25.888-35.616a215.584 215.584 0 1 0-314.4 290.624zM32 407.584a279.584 279.584 0 0 1 480-194.944 279.584 279.584 0 0 1 480 194.944 278.144 278.144 0 0 1-113.024 224.512l-295.36 243.392a128 128 0 0 1-165.888-2.592L129.984 620.16A278.976 278.976 0 0 1 32 407.584z"
                                    p-id="1936"></path>
                            </svg>

                            <!-- volume off icon -->
                            <svg t="1676884758783" class="swap-on fill-current" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="1493" width="36" height="36">
                                <path
                                    d="M32 407.584a279.584 279.584 0 0 1 480-194.944 279.584 279.584 0 0 1 480 194.944 278.144 278.144 0 0 1-113.024 224.512L562.592 892.8a96 96 0 0 1-124.416-1.952l-308.16-270.688A278.976 278.976 0 0 1 32 407.584z"
                                    fill="#d81e06" p-id="1494"></path>
                            </svg>
                        </label>
                        <div class="text-xl">{{ props.likeNum }}</div>
                    </div>

                    <div class="text-center flex justify-around items-center">
                        <label class="swap" @click="cardDetail()">
                            <svg t="1676885015492" class="swap-off fill-current" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="4240" width="36" height="36">
                                <path
                                    d="M864 64H160C107.072 64 64 107.072 64 160v608c0 52.928 43.072 96 96 96h61.92v123.232L443.84 864H864c52.928 0 96-43.072 96-96V160c0-52.928-43.072-96-96-96z m32 704a32 32 0 0 1-32 32H443.84c-10.912 0-21.664 2.816-31.072 8.064l-126.88 70.4V864c0-35.296-28.704-64-64-64H160c-17.632 0-32-14.336-32-32V160c0-17.632 14.368-32 32-32h704c17.664 0 32 14.368 32 32v608z"
                                    p-id="4241"></path>
                                <path
                                    d="M640 520H256a32 32 0 1 0 0 64h384a32 32 0 1 0 0-64zM768 296H256a32 32 0 0 0 0 64h512a32 32 0 1 0 0-64z"
                                    p-id="4242"></path>
                            </svg>
                        </label>
                        <div class="text-xl">{{ props.commentNum }}</div>
                    </div>
                    <div class=" text-center flex justify-around items-center">
                        <label class="swap" @click="handleclog">
                            <svg t="1676885181613" class="swap-off fill-current" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="5020" width="36" height="36">
                                <path d="M224 512m-80 0a80 80 0 1 0 160 0 80 80 0 1 0-160 0Z" p-id="5021">
                                </path>
                                <path d="M512 512m-80 0a80 80 0 1 0 160 0 80 80 0 1 0-160 0Z" p-id="5022">
                                </path>
                                <path d="M800 512m-80 0a80 80 0 1 0 160 0 80 80 0 1 0-160 0Z" p-id="5023">
                                </path>
                            </svg>
                        </label>
                        <!-- <div class="text-xl">10000</div> -->
                    </div>

                </div>
            </div>
        </div>

    </div>
</template>
<script lang="ts" setup>
import rpCarousel from '@/components/basic/rp-carousel.vue';
import { ref, reactive } from 'vue';
import type { Ref } from 'vue';

const imgSrc: Ref<string> = ref('');

const emit = defineEmits(['clickit'])

const bigImg = () => {
    emit('clickit')
}


interface Props {
    title: string
    piclist: Array<string>
    username: string
    useravatar: string
    richtext: string
    rank: number
    liked: boolean
    likeNum: number
    commentNum: number
}
const props = withDefaults(defineProps<Props>(), {
})

function handleclog() {
    console.log('click');
}
function handlelike() {
    console.log('like');
}
function cardDetail() {
    console.log('open card Detail');
}
</script>
<style lang="less">
@media (max-width: 640px) {

    .hiddenstat {
        display: none;
    }

}
</style>
