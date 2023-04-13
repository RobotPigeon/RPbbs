<template>
    <div class=" flex flex-col">
        <div class="alert shadow-2xl bg-base-100 mt2">
            <div>
                <span class="card-title">参赛球队</span>
            </div>
        </div>
        <div class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 rounded-box postcontent h-100vh">
            <div class="flex w-full mx-auto px-0 py-0">
                <div class="grid grid-cols-3 w-full h-full m2 p2 ">
                    <div class="card w-a h-a bg-base-100 shadow-xl m2" v-for="item in teamlist.value">
                        <figure><img src="@/assets/images/team.jpg" alt="team" />
                        </figure>
                        <div class="card-body">
                            <h3 class="card-title">
                                {{ item.squad }}
                            </h3>
                        </div>
                        <div class="grid grid-cols-2">
                            <div class="card-actions">
                            <button class="btn btn-ghost" @click="toPlayerList(item)">球员列表</button>
                        </div>
                        <div class="card-actions">
                            <button class="btn btn-ghost" @click="toPerformance(item)">表现分析</button>
                        </div>
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
import { getTeamList } from '@/api/football';


//声明队伍列表变数
const teamlist: any = reactive(
    []
)

//获取队伍列表
const getTeamListData = async () => {
    const res = await getTeamList();
    teamlist.value = res.data;
    console.log(teamlist.value);
}

//跳转到队伍下球员列表，携带队伍名
const toPlayerList = (item: any) => {
    router.push({
        path: '/home/football/player',
        query: {
            squad: item.squad
        }
    })
}
//跳转到队伍表现分析，携带队伍id
const toPerformance = (item: any) => {
    router.push({
        path: '/home/football/teamperformance',
        query: {
            id: item.id
        }
    })
}


//页面加载时获取队伍列表
onMounted(() => {
    getTeamListData();
})

</script>