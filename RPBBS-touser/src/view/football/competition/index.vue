<template>
    <main class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 min-h-100vh rounded-box content">
        <div class="flex w-full mx-auto px-0 py-0">
            <div class="flex flex-wrap w-full h-full flex ">
                <div class="alert shadow-2xl bg-base-100 mt2">
                    <div>
                        <span class="card-title">全部分区</span>
                    </div>
                </div>
                <div class="card card-side bg-base-100 shadow-xl w-full">
                    <figure>
                        <div class="avatar items-center">
                            <div class="w-24  rounded ml1">
                                <img src="http://192.168.10.5:8081/img/1681292146153.jpg" />
                            </div>
                        </div>
                    </figure>
                    <div class="card-body w-80%">
                        <h2 class="card-title">卡塔尔世界杯</h2>
                        <p>2022年于卡塔尔举办的世界杯赛事</p>
                        <div class="flex justify-end">
                            <button class="btn btn-primary" @click="toPartition()">赛程数据</button>
                        </div>
                        <div class="flex justify-end">
                            <button class="btn btn-primary" @click="toTeam()">参赛队伍</button>
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
//引入板块api
import { getBlocklist } from '@/api/block';
import router from '@/router';


function toPartition() {
    //跳转到分区，并且传递分区id
    router.push({ path: '/home/football/match' });
}
function toTeam() {
    //跳转到分区，并且传递分区id
    router.push({ path: '/home/football/team' });
}
</script>
  
<style scoped lang='less'></style>