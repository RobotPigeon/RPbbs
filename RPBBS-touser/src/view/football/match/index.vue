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
                        {{ item.Round }}
                    </div>
                    <div class="grid grid-cols-3 w-full h-full m2 p2">
                        <div class="flex flex-col justify-center">
                            <Label class="badge">主队</Label>
                            <div class="stat-value text-2xl">
                                {{ item.Home }}
                            </div>
                            <div>
                                预期进球(XG):{{ item.home_xG }}
                            </div>
                        </div>
                        <div class="countdown font-mono text-6xl justify-start">
                            {{ item.Score }}
                        </div>
                        <div class="flex flex-col justify-center">
                            <Label class="badge">客队</Label>
                            <div class="stat-value text-2xl">
                                {{ item.Away }}
                            </div>
                            <div>
                                预期进球(XG):{{ item.away_xG }}
                            </div>
                        </div>
                    </div>
                    <div class="flex flex-col ml2 countdown font-mono text-xl">
                        {{ item.Date }}||{{ item.Time }}
                    </div>
                    <div class="ml2">
                        <label class="badge" for="">举办地</label>
                        <div class="flex flex-col countdown font-mono text-xl">
                            {{ item.Venue }}
                        </div>
                    </div>
                    <div class="grid grid-cols-2">
                        <div class="ml2">
                            <label class="badge" for="">上座人数</label>
                            <div class="flex flex-col countdown font-mono text-xl">
                                {{ item.Attendance }}
                            </div>
                        </div>
                        <div class="ml2">
                            <label class="badge" for="">裁判</label>
                            <div class="flex flex-col countdown font-mono text-xl">
                                {{ item.Referee }}
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
import { getBlocklist } from '@/api/block';
import router from '@/router';


function toPartition() {
    //跳转到分区，并且传递分区id
    router.push({ path: '/home/content' });
}
const matchList: any = reactive(
    [{
        "Round": "Group stage",
        "Date": "2022/11/20",
        "Time": "19:00 (00:00)",
        "Home": "Qatar qa",
        "home_xG": "0.3",
        "Score": "0–2",
        "away_xG": "1.2",
        "Away": "ec Ecuador",
        "Attendance": "67372",
        "Venue": "Al Bayt Stadium (Neutral Site)",
        "Referee": "Daniele Orsato",
        "Notes": ""
    },
    {
        "Round": "Group stage",
        "Date": "2022/11/21",
        "Time": "16:00 (21:00)",
        "Home": "England eng",
        "home_xG": "2.1",
        "Score": "6–2",
        "away_xG": "1.4",
        "Away": "ir IR Iran",
        "Attendance": "45334",
        "Venue": "Khalifa International Stadium (Neutral Site)",
        "Referee": "Raphael Claus",
        "Notes": ""
    },
    {
        "Round": "Group stage",
        "Date": "2022/11/21",
        "Time": "19:00 (00:00)",
        "Home": "Senegal sn",
        "home_xG": "0.9",
        "Score": "0–2",
        "away_xG": "0.7",
        "Away": "nl Netherlands",
        "Attendance": "41721",
        "Venue": "Al Thumama Stadium (Neutral Site)",
        "Referee": "Wilton Sampaio",
        "Notes": ""
    }, {
        "Round": "Group stage",
        "Date": "2022/11/20",
        "Time": "19:00 (00:00)",
        "Home": "Qatar qa",
        "home_xG": "0.3",
        "Score": "0–2",
        "away_xG": "1.2",
        "Away": "ec Ecuador",
        "Attendance": "67372",
        "Venue": "Al Bayt Stadium (Neutral Site)",
        "Referee": "Daniele Orsato",
        "Notes": ""
    },
    {
        "Round": "Group stage",
        "Date": "2022/11/21",
        "Time": "16:00 (21:00)",
        "Home": "England eng",
        "home_xG": "2.1",
        "Score": "6–2",
        "away_xG": "1.4",
        "Away": "ir IR Iran",
        "Attendance": "45334",
        "Venue": "Khalifa International Stadium (Neutral Site)",
        "Referee": "Raphael Claus",
        "Notes": ""
    },
    {
        "Round": "Group stage",
        "Date": "2022/11/21",
        "Time": "19:00 (00:00)",
        "Home": "Senegal sn",
        "home_xG": "0.9",
        "Score": "0–2",
        "away_xG": "0.7",
        "Away": "nl Netherlands",
        "Attendance": "41721",
        "Venue": "Al Thumama Stadium (Neutral Site)",
        "Referee": "Wilton Sampaio",
        "Notes": ""
    },
    ]
)

</script>
  
<style scoped lang='less'></style>