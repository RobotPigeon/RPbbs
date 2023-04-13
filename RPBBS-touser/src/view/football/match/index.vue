<template>
    <main class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 min-h-100vh rounded-box content">
        <div class="flex w-full mx-auto px-0 py-0">
            <div class="flex flex-wrap w-full h-full flex ">
                <div class="alert shadow-2xl bg-base-100 mt2">
                    <div>
                        <span class="card-title">赛程</span>
                    </div>
                </div>
                <div class="card card-side bg-base-100 shadow-xl w-full flex flex-col mt2" v-for="item in matchList">
                    <div class="flex flex-col ml2 countdown font-mono text-xl badge">
                        阶段:{{ item.round }}
                    </div>
                    <div class="grid grid-cols-3 w-full h-full m2 p2">
                        <div class="flex flex-col justify-center">
                            <Label class="badge">主队</Label>
                            <div class="stat-value text-2xl">
                                {{ item.home }}
                            </div>
                            <div>
                                预期进球(XG):{{ item.homeXg }}
                            </div>
                        </div>
                        <div class="countdown font-mono text-4xl justify-center">
                            {{ item.score }}
                        </div>
                        <div class="flex flex-col justify-end ml4">
                            <Label class="badge">客队</Label>
                            <div class="stat-value text-2xl">
                                {{ item.away }}
                            </div>
                            <div>
                                预期进球(XG):{{ item.awayXg }}
                            </div>
                        </div>
                    </div>
                    <div class="flex flex-col ml2 countdown font-mono text-xl">
                        {{ item.date }}||{{ item.time }}
                    </div>
                    <div class="ml2">
                        <label class="badge" for="">举办地</label>
                        <div class="flex flex-col countdown font-mono text-xl">
                            {{ item.venue }}
                        </div>
                    </div>
                    <div class="grid grid-cols-2">
                        <div class="ml2">
                            <label class="badge" for="">上座人数</label>
                            <div class="flex flex-col countdown font-mono text-xl">
                                {{ item.attendance}}
                            </div>
                        </div>
                        <div class="ml2">
                            <label class="badge" for="">裁判</label>
                            <div class="flex flex-col countdown font-mono text-xl">
                                {{ item.referee }}
                            </div>
                        </div>
                    </div>
                </div>
                <div class="alert shadow-2xl bg-base-100 mt2">
                    <div>
                        <span class="card-title">赛程</span>
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
import { getMatchList } from '@/api/football';
import router from '@/router';

//进入页面时，获取板块数据
onMounted(() => {
    getMatchListData()
})

function toPartition() {
    //跳转到分区，并且传递分区id
    router.push({ path: '/home/content' });
}

const matchList: any = reactive(
    []
)
function getMatchListData() {
    getMatchList().then((res: any) => {
        matchList.push(...res.data)
    })
}

</script>
  
<style scoped lang='less'></style>