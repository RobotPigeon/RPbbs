<template>
    <div class=" flex flex-col">
            <div class="h-a items-center mb1 w-full flex">
                <div class="alert shadow-2xl bg-base-100 mt2">
                    <div>
                        <span class="card-title">{{squad}}阵容球员</span>
                    </div>
                </div>
            </div>
        <div class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 rounded-box postcontent h-100vh">
            <div class="flex w-full mx-auto px-0 py-0">
                <div class="grid grid-cols-3 w-full h-full m2 p2 ">
                    <div class="card w-a h-a bg-base-100 shadow-xl m2" v-for="item in playerlist.value">
                        <figure><img src="@/assets/images/avatar.jpg" alt="player" />
                        </figure>
                        <div class="card-body">
                            <p>{{item.player}}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup lang='ts'>
import { ref, reactive, onMounted, onUnmounted } from 'vue'
import type { Ref } from 'vue';
import router from '@/router';
import {getPlayersByTeam } from '@/api/football';

//页面加载时执行
onMounted(() => {
    getPlayerListData();
});

//获取路由参数
const squad = router.currentRoute.value.query.squad;

//声明队伍下球员列表变数
const playerlist: any = reactive(
    []
)
//获取队伍下球员列表
const getPlayerListData = async () => {
    const res = await getPlayersByTeam(squad);
    playerlist.value = res.data;
    console.log(playerlist.value);
}
</script>