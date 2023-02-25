<template>
    <main class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 min-h-100vh rounded-box content">
        <div class="flex w-full mx-auto px-0 py-0">
            <div class="flex flex-wrap w-full h-full flex ">
                <div class="alert shadow-2xl bg-base-100 mt2">
                    <div>
                        <span class="card-title">全部分区</span>
                    </div>
                </div>
                <div class="card card-side bg-base-100 shadow-xl w-full my1 px2" @click="toPartition()">
                    <figure>
                        <div class="avatar items-center">
                            <div class="w-24  rounded ml1">
                                <img :src="useravatar" />
                            </div>
                        </div>
                    </figure>
                    <div class="card-body w-80%">
                        <h2 class="card-title">{{ title }}</h2>
                        <p>{{ text }}</p>
                        <span class="stat-desc">发帖:1000/回复:10000</span>

                    </div>
                </div>
                <div class="card card-side bg-base-100 shadow-xl w-full my1 px2">
                    <figure>
                        <div class="avatar items-center">
                            <div class="w-24 rounded ml2">
                                <img :src="useravatar" />
                            </div>
                        </div>
                    </figure>
                    <div class="card-body w-80%">
                        <h2 class="card-title">New movie is released!</h2>
                        <p>Click the button to watch on Jetflix app.</p>
                        <span class="stat-desc">发帖:1000/回复:10000</span>
                    </div>
                </div>
            </div>
        </div>

    </main>
</template>
  
<script setup lang='ts'>
import { ref, reactive, onMounted, onUnmounted } from 'vue'
import type { Ref } from 'vue';
import rpCard from '@/components/basic/rp-card.vue';
const title: string = '如何评价首先是然后再是'
const useravatar: string = 'https://lain.bgm.tv/r/400/pic/cover/l/a4/16/296739_71dLe.jpg'
const text: string = '啊啊啊啊啊啊啊啊啊啊啊啊啊啊'

function toPartition(){
    console.log('进入分区');
    
}
</script>
  
<style scoped lang='less'></style>