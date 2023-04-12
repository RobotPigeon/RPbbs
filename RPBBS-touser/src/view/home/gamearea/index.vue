<template>
    <main class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 min-h-100vh rounded-box content">
        <rp-banner :list="piclist.list"></rp-banner>
        <div class="flex w-full mx-auto px-0 py-0">
            <div class="flex flex-wrap w-full h-full flex">
                <div class="alert shadow-2xl bg-base-100">
                    <div>
                        <span class="card-title">热门栏目</span>
                    </div>
                </div>
                <div v-for="item in blocklist.list" class="card card-side bg-base-100 shadow-xl w-49% ml0.5% my1 "
                    @click="toPartition(item.id)">
                    <figure>
                        <div class="avatar items-center">
                            <div class="w-24">
                                <img :src="item.picPath" />
                            </div>
                        </div>
                    </figure>
                    <div class="card-body w-80%">
                        <h2 class="card-title text-3">{{ item.blockName }}</h2>
                        <p class="text-1">欧内的手好汉汉汉汉汉汉汉汉汉汉汉汉汉汉汉</p>
                        <!-- <span class="stat-desc">发帖:1000/回复:10000</span> -->
                        <div class="flex justify-end">
                        </div>
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
import rpBanner from '@/components/basic/rp-banner.vue';
//引入板块api
import { getBlocklist } from '@/api/block';
import router from '@/router';

//获取板块列表
const blocklist = reactive({
    list: []
}) as any;

//创建轮播图数据
const piclist = reactive({
    list: [
        'https://lain.bgm.tv/pic/cover/l/83/cf/304217_Yu97O.jpg'
        ,
        'https://lain.bgm.tv/pic/cover/l/83/cf/304217_Yu97O.jpg'
    ]
}) as any;

//获取板块列表
getBlocklist().then((res: any) => {
    blocklist.list = res.data.records;
    console.log(blocklist.list);
})

function toPartition(id: string) {
    //跳转到分区，并且传递分区id
    router.push({ path: '/home', query: { block: id } });
}
</script>
  
<style scoped lang='less'></style>