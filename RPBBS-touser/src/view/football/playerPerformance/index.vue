<template>
    <div class=" flex flex-col">
        <div class="alert shadow-2xl bg-base-100 mt2">
            <div>
                <span class="card-title">表现分析</span>
            </div>
        </div>
        <div class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 rounded-box postcontent h-100vh">
            <div class="flex w-full mx-auto px-0 py-0 justify-center">
                <div class="stats shadow">

                    <div class="stat">
                        <div class="stat-figure text-primary">
                            <svg t="1681377917121" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="2870" width="24" height="24">
                                <path
                                    d="M449.12 654.24l-40.48-102.24a22.24 22.24 0 0 1 7.36-25.6l84.64-70.24a22.56 22.56 0 0 1 26.4-1.6l92.96 58.88a22.4 22.4 0 0 1 9.76 24.48l-28.16 106.56a22.56 22.56 0 0 1-20.32 16.96l-109.76 6.88a22.72 22.72 0 0 1-22.4-14.08zM807.52 700.8a338.08 338.08 0 0 1-164 148 20.8 20.8 0 0 1-1.12-12.48l5.76-28.16 16-80a22.4 22.4 0 0 1 5.28-10.24 21.92 21.92 0 0 1 13.6-6.88l96-10.72 14.4-1.6a20.96 20.96 0 0 1 14.08 2.08zM849.12 530.72a21.44 21.44 0 0 1-23.04 0.96l-11.2-6.24-85.44-48a21.76 21.76 0 0 1-10.56-23.2l22.56-108.96a21.6 21.6 0 0 1 18.72-17.12l13.6-1.44a334.24 334.24 0 0 1 75.36 204zM290.56 510.08l-62.24 56.8L208 585.12a21.44 21.44 0 0 1-25.12 2.72l-4.16-2.4a325.6 325.6 0 0 1-2.72-47.04 333.28 333.28 0 0 1 43.84-166.08l8.32-0.96a21.28 21.28 0 0 1 21.92 12.48l45.76 101.12a21.28 21.28 0 0 1-5.28 25.12zM607.04 255.04l-82.24 74.88a21.76 21.76 0 0 1-25.28 2.88l-96-55.04a21.76 21.76 0 0 1-10.56-23.2l7.04-33.44a339.36 339.36 0 0 1 205.76-6.72l7.2 16a21.92 21.92 0 0 1-5.92 24.64zM451.36 869.6a336 336 0 0 1-193.44-110.72 21.76 21.76 0 0 1 17.44-12.96l110.56-12.32a21.28 21.28 0 0 1 11.84 2.08 20.64 20.64 0 0 1 10.24 10.56l34.4 75.84 11.52 25.92a21.6 21.6 0 0 1-2.56 21.6z"
                                    fill="#4D4D4D" p-id="2871"></path>
                                <path
                                    d="M492.8 912a352 352 0 0 1-266.56-121.6A350.72 350.72 0 0 1 144 608a333.92 333.92 0 0 1-3.84-48 352 352 0 0 1 705.28-8v8a352 352 0 0 1-352 352z m0-673.44a320.8 320.8 0 1 0 124.96 616.48A320 320 0 0 0 813.76 560v-7.36a320.96 320.96 0 0 0-232.64-302.08 321.6 321.6 0 0 0-88.32-12.16z"
                                    fill="" p-id="2872"></path>
                                <path
                                    d="M400 617.44a16 16 0 0 1-14.4-9.44l-11.68-29.28a37.44 37.44 0 0 1 11.04-42.72l85.6-72a37.28 37.28 0 0 1 44-2.72l35.2 22.24a16 16 0 1 1-16.96 26.88l-35.2-22.24a5.76 5.76 0 0 0-6.72 0L405.28 560a5.92 5.92 0 0 0-1.76 6.56l12.48 29.12a16 16 0 0 1-8.96 20.64 14.72 14.72 0 0 1-7.04 1.12zM449.92 705.12a37.44 37.44 0 0 1-34.88-23.68L400 643.68a16 16 0 0 1 8.96-20.64 16 16 0 0 1 20.64 8.8l15.04 37.92a5.92 5.92 0 0 0 5.6 3.52l44.8-2.88a16 16 0 0 1 16 14.88 16 16 0 0 1-14.88 16.96l-44.64 2.88zM536.96 699.68a16 16 0 0 1-0.96-32l25.28-1.6a5.6 5.6 0 0 0 5.12-4.16l27.68-107.84a5.92 5.92 0 0 0-2.56-6.24l-24-16a16 16 0 0 1-4.96-21.92 16 16 0 0 1 21.92-4.96l24.16 15.2a37.12 37.12 0 0 1 16 40.96l-27.52 107.84a37.44 37.44 0 0 1-33.92 28.16l-25.44 1.6zM615.04 890.56l-5.92-15.2a37.76 37.76 0 0 1-1.12-21.44l22.4-108.96a37.76 37.76 0 0 1 32-29.76l110.56-12.32a36.8 36.8 0 0 1 23.2 4.96l13.44 7.84-7.52 13.6a355.04 355.04 0 0 1-171.84 154.88zM760.48 736l-94.72 10.56a6.08 6.08 0 0 0-3.36 1.6 5.92 5.92 0 0 0-1.6 2.88l-18.88 92.16a324.8 324.8 0 0 0 118.56-107.2zM817.12 571.2a38.24 38.24 0 0 1-18.56-4.8l-96-55.04a37.6 37.6 0 0 1-18.24-40.16l22.56-108.96a37.44 37.44 0 0 1 32-29.76l22.24-2.4 5.44 6.72a349.44 349.44 0 0 1 78.88 214.4V560l-7.04 4.8a37.44 37.44 0 0 1-21.28 6.4z m-69.92-208h-4.96a5.92 5.92 0 0 0-4.96 4.48l-22.4 108.96a5.6 5.6 0 0 0 2.88 6.08l96 54.24a315.2 315.2 0 0 0-66.56-173.28zM174.24 627.52a38.4 38.4 0 0 1-18.56-4.96l-10.88-6.4L144 608a333.92 333.92 0 0 1-3.84-48 352 352 0 0 1 45.92-174.08l4-7.04 16-1.76a37.76 37.76 0 0 1 38.4 21.92l45.92 101.28a37.76 37.76 0 0 1-8.96 43.2l-81.92 74.08a37.44 37.44 0 0 1-25.28 9.92z m0-32a5.28 5.28 0 0 0 4-1.6l82.24-74.88a5.92 5.92 0 0 0 1.28-6.72l-45.76-100.96a5.6 5.6 0 0 0-5.92-3.52A320 320 0 0 0 172 560a307.84 307.84 0 0 0 2.08 35.68zM490.56 372.32A37.6 37.6 0 0 1 472 368l-96-55.04A37.44 37.44 0 0 1 357.12 272l8.8-42.24 8.32-2.88a355.36 355.36 0 0 1 215.52-7.04l7.04 1.92 10.24 22.4a37.44 37.44 0 0 1-8.96 43.2L576 308a16 16 0 0 1-22.4-0.96 16 16 0 0 1 0.96-22.56L576 264a5.6 5.6 0 0 0 1.44-6.56l-4-8.8a324.16 324.16 0 0 0-180.64 5.44l-5.12 24.48a5.76 5.76 0 0 0 2.72 6.08l96 55.04a5.6 5.6 0 0 0 6.56 0l24.96-22.72a16 16 0 1 1 21.44 23.52l-24.96 22.72a37.76 37.76 0 0 1-23.84 9.12zM438.4 907.84l-9.6-1.76a354.24 354.24 0 0 1-202.56-115.84l-6.4-7.52 3.84-9.12a37.44 37.44 0 0 1 30.4-22.56l110.56-12.48a37.6 37.6 0 0 1 20.48 3.68 36.8 36.8 0 0 1 17.76 18.08l45.92 101.44a37.44 37.44 0 0 1-4.48 38.4z m-176-125.76a321.44 321.44 0 0 0 156.16 89.28l-44.32-97.76a4.8 4.8 0 0 0-2.56-2.72 4.96 4.96 0 0 0-3.2 0z"
                                    fill="" p-id="2873"></path>
                                <path
                                    d="M382.56 573.6a16 16 0 0 1-5.44-0.96l-23.84-8.64a16 16 0 1 1 10.88-29.92l23.84 8.64a16 16 0 0 1 9.44 20.48 16 16 0 0 1-14.88 10.4zM324.8 552.48a16 16 0 0 1-5.44-0.96L272 534.24a16 16 0 0 1 10.88-29.92l47.2 17.28a16 16 0 0 1-5.44 30.88zM476.96 356.32h31.84v115.52h-31.84zM602.08 554.24a16 16 0 0 1-14.72-9.44 16 16 0 0 1 8.32-20.96l55.04-24.16a16 16 0 0 1 20.96 8.16 16 16 0 0 1-8.16 20.96L608 552.96a14.56 14.56 0 0 1-5.92 1.28z"
                                    fill="" p-id="2874"></path>
                                <path
                                    d="M685.44 517.76a16 16 0 0 1-14.56-9.6 16 16 0 0 1 8.16-20.96l13.6-5.92a16 16 0 0 1 12.64 29.12l-13.44 5.92a14.88 14.88 0 0 1-6.4 1.44zM570.08 677.024l23.008-22.016 68.896 72.048-23.008 22zM366.208 746.24l60.928-70.208 24.048 20.88-60.944 70.192zM324.8 344a16 16 0 0 1-10.08-28.32l42.56-34.56a16 16 0 0 1 20 24.64l-42.4 34.56a16 16 0 0 1-10.08 3.68zM229.44 421.6a16 16 0 0 1-9.92-28.16l64-52.64A16 16 0 1 1 304 365.44l-64 52.64a16 16 0 0 1-10.56 3.52zM708.8 381.44a16 16 0 0 1-8.64-2.56l-117.44-76.64a16 16 0 0 1-4.64-21.92 16 16 0 0 1 22.08-4.64L717.44 352a16 16 0 0 1-8.64 29.28zM760.32 736a10.88 10.88 0 0 1-3.2 0 16 16 0 0 1-12.48-18.72l11.52-56.8a16 16 0 1 1 32 6.4l-11.52 56.8a16 16 0 0 1-16.32 12.32zM779.68 640h-3.2a16 16 0 0 1-12.32-18.72l14.24-71.04a16 16 0 0 1 32 6.4l-14.4 70.88a16 16 0 0 1-16.32 12.48zM541.28 850.72a16 16 0 0 1-1.12-32l87.36-5.92a16 16 0 1 1 2.08 32l-87.2 5.92zM422.72 858.72a16 16 0 0 1-0.96-32l80-5.44a16 16 0 0 1 16.96 14.88 16 16 0 0 1-14.88 16.96l-80 5.28zM275.36 773.76a16 16 0 0 1-14.72-10.08l-25.92-65.92a16 16 0 0 1 29.6-11.68L290.24 752a16 16 0 0 1-8.96 20.64 15.04 15.04 0 0 1-5.92 1.12zM235.52 672a16 16 0 0 1-14.72-10.08l-26.88-68.64a16 16 0 0 1 8.96-20.48 16 16 0 0 1 20.64 8.96l26.88 68.48a16 16 0 0 1-8.96 20.64 16 16 0 0 1-5.92 1.12z"
                                    fill="" p-id="2875"></path>
                                <path
                                    d="M224 594.4a13.44 13.44 0 0 1-13.12-11.2 136 136 0 0 1 16-86.72 13.28 13.28 0 0 1 22.24 14.24 109.76 109.76 0 0 0-12.64 68.32 13.28 13.28 0 0 1-11.04 16z"
                                    fill="#FFFFFF" p-id="2876"></path>
                                <path d="M226.24 617.12m-14.24 0a14.24 14.24 0 1 0 28.48 0 14.24 14.24 0 1 0-28.48 0Z"
                                    fill="#FFFFFF" p-id="2877"></path>
                            </svg>
                        </div>
                        <div class="stat-title">进球</div>
                        <div class="stat-value text-primary">{{ playerInfo.gls }}</div>
                        <div class="stat-figure text-primary">
                        </div>
                        <div class="stat-title">助攻</div>
                        <div class="stat-value text-primary">{{ playerInfo.ast }}</div>
                    </div>

                    <div class="stat">
                        <div class="stat-figure text-secondary">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                class="inline-block w-8 h-8 stroke-current">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                    d="M13 10V3L4 14h7v7l9-11h-7z"></path>
                            </svg>
                        </div>
                        <div class="stat-title">出场次数</div>
                        <div class="stat-value text-secondary">{{ playerInfo.mp }}</div>
                        <div class="stat-title">出场时间</div>
                        <div class="stat-value text-secondary">{{ playerInfo.min }}min</div>
                    </div>

                    <div class="stat">
                        <div class="stat-figure text-secondary">
                            <div class="avatar">
                                <div class="w-16 rounded-full">
                                    <img src="@/assets/images/avatar.jpg" />
                                </div>
                            </div>
                        </div>
                        <div class="stat-value">位置:{{ playerInfo.pos }}</div>
                        <div class="stat-title">全名:{{ playerInfo.player }}</div>
                        <div class="stat-desc text-secondary">年龄:{{ playerInfo.age }} 出生年份：{{ playerInfo.born }}</div>
                    </div>

                </div>
            </div>
            <div class="alert shadow-2xl b-4 bg-base-100 mt2 p2">
                <div>
                    <span class="card-title">进攻表现</span>
                </div>
            </div>
            <div class="card bg-base-100 mt2 flex-row ">
                <div id="Shootandgoal" w-80 h-80></div>
                <div>
                    <div class="stats stats-vertical shadow mt10">
                        <div class="stat">
                            <div class="stat-title">射门次数</div>
                            <div class="stat-value">{{ playerShooting.sh }}</div>
                            <div class="stat-desc">{{ playerShooting.sh90 }}(每90分钟)</div>
                            <div class="stat-desc">平均射门距离:{{ playerShooting.adist }}m</div>
                        </div>

                        <div class="stat">
                            <div class="stat-title">射正次数</div>
                            <div class="stat-value">{{ playerShooting.soT }}</div>
                            <div class="stat-desc">{{ playerShooting.sot90 }}(每90分钟)</div>
                        </div>
                    </div>
                </div>
                <div>
                    <div class="stats stats-vertical shadow mt10">
                        <div class="stat">
                            <div class="stat-title">预期进球数(XG)</div>
                            <div class="stat-value">{{ playerShooting.xg }}</div>
                            <div class="stat-desc">{{ playerShooting.npxG }}(去除点球)</div>
                        </div>

                        <div class="stat">
                            <div class="stat-title">非运动战射门(点球)</div>
                            <div class="stat-value">{{ playerShooting.pkatt }}</div>
                            <div class="stat-desc">任意球：{{ playerShooting.fk }}</div>
                            <div class="stat-desc">点球命中：{{ playerShooting.pk }}</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="alert shadow-2xl b-4 bg-base-100 mt2 p2">
                <div>
                    <span class="card-title">防守表现</span>
                </div>
            </div>
            <div class="card bg-base-100 mt2 flex-row ">
                <div class="flex flex-col">
                    <div id="defense3rd" w-50 h-50></div>
                    <div id="defenseblock" w-50 h-50></div>
                </div>
                <div>
                    <div class="stats stats-vertical shadow mt10">
                        <div class="stat">
                            <div class="stat-title">三区抢断表现</div>
                            <div class="stat-value">{{ playerDefense.tkl }}</div>
                            <div class="stat-desc">前场{{ playerDefense.att3rd }}次</div>
                            <div class="stat-desc">中场{{ playerDefense.mid3rd }}次</div>
                            <div class="stat-desc">后场{{ playerDefense.def3rd }}次</div>
                        </div>
                        <div class="stat">
                            <div class="stat-title">拦截表现</div>
                            <div class="stat-value">{{ playerDefense.blocks }}</div>
                            <div class="stat-desc">射门拦截{{ playerDefense.shotBlock }}次</div>
                            <div class="stat-desc">传球拦截{{ playerDefense.passBlock }}次</div>
                        </div>
                    </div>
                </div>
                <div class="flex flex-col">
                    <div id="defensectklL" w-50 h-50></div>
                    <div id="defenseblock" w-50 h-50></div>
                </div>
                <div>
                    <div class="stats stats-vertical shadow mt10">
                        <div class="stat">
                            <div class="stat-title">防守对抗</div>
                            <div class="stat-value">{{ playerDefense.catt }}</div>
                            <div class="stat-desc">成功{{ playerDefense.ctkl }}次</div>
                            <div class="stat-desc">失败{{ playerDefense.ctklL }}次</div>
                        </div>
                        <div class="stat">
                            <div class="stat-title">解围</div>
                            <div class="stat-value">{{ playerDefense.clear }}</div>
                            <div class="stat-desc">抢断{{ playerDefense.tkl }}次</div>
                            <div class="stat-desc">抢断成功{{ playerDefense.tklW }}次</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="alert shadow-2xl b-4 bg-base-100 mt2 p2">
                <div>
                    <span class="card-title">传球表现</span>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup lang='ts'>
import { ref, onMounted } from 'vue'
import type { Ref } from 'vue';
//引入api获取球员信息
import { getPlayerById } from '@/api/football';
import router from '@/router';
import { init } from 'echarts';
//ECharts, EChartsOption
import type { ECharts, EChartsOption } from 'echarts';

//射门表现饼图
function charshootandgoal() {
    const charshootandgoal = document.getElementById('Shootandgoal') as HTMLElement;
    const charESAG: ECharts = init(charshootandgoal);
    console.log(optionESAG);
    charESAG.setOption(optionESAG);
};
//三区防守表现饼图
function chardefense() {
    const chardefense = document.getElementById('defense3rd') as HTMLElement;
    const charED: ECharts = init(chardefense);
    console.log(optionED3RD);
    charED.setOption(optionED3RD);
};
//拦截表现饼图
function charblock() {
    const charblock = document.getElementById('defenseblock') as HTMLElement;
    const charEB: ECharts = init(charblock);
    console.log(optionEBlock);
    charEB.setOption(optionEBlock);
};
//对抗抢断表现饼图
function charctkl() {
    const charctkl = document.getElementById('defensectklL') as HTMLElement;
    const charECTKL: ECharts = init(charctkl);
    console.log(optionECtkl);
    charECTKL.setOption(optionECtkl);
};
//声明球员信息变量
const playerInfo: Ref<any> = ref({});
const playerShooting: Ref<any> = ref({});
const playerDefense: Ref<any> = ref({});
const playerPassing: Ref<any> = ref({});
const optionESAG: any = {

    title: {
        text: '射门表现',
        left: 'center'
    },
    series: [
        {
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: 'center'
            },
            labelLine: {
                show: false
            },
            emphasis: {
                label: {
                    show: true,
                    fontSize: '30',
                    fontWeight: 'bold'
                }
            },
            data: [
                {
                    value: 0,
                    name: '射正次数'
                },
                {
                    value: 0,
                    name: '射失次数'
                }
            ],
        }
    ]
};
const optionED3RD: any = {

    title: {
        text: '三区抢断表现',
        left: 'center'
    },
    series: [
        {
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: 'center'
            },
            labelLine: {
                show: false
            },
            emphasis: {
                label: {
                    show: true,
                    fontSize: '30',
                    fontWeight: 'bold'
                }
            },
            data: [
                {
                    value: 0,
                    name: '进攻三区'
                },
                {
                    value: 0,
                    name: '中场三区'
                },
                {
                    value: 0,
                    name: '防守三区'
                }
            ],
        }
    ]
};
const optionEBlock: any = {

    title: {
        text: '封堵表现',
        left: 'center'
    },
    series: [
        {
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: 'center'
            },
            labelLine: {
                show: false
            },
            emphasis: {
                label: {
                    show: true,
                    fontSize: '30',
                    fontWeight: 'bold'
                }
            },
            data: [
                {
                    value: 0,
                    name: '射门封堵'
                },
                {
                    value: 0,
                    name: '传球封堵'
                },
            ],
        }
    ]
};
const optionECtkl: any = {

    title: {
        text: '对抗表现',
        left: 'center'
    },
    series: [
        {
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: 'center'
            },
            labelLine: {
                show: false
            },
            emphasis: {
                label: {
                    show: true,
                    fontSize: '30',
                    fontWeight: 'bold'
                }
            },
            data: [
                {
                    value: 0,
                    name: '对抗成功'
                },
                {
                    value: 0,
                    name: '对抗失败'
                },
            ],
        }
    ]
};
//获取路由参数
const id = router.currentRoute.value.query.id;
//页面加载时执行
onMounted(() => {
    //确保只有获取球员信息后，才能进行图表渲染
    getPlayerInfo();

});
function getPlayerInfo() {
    getPlayerById(id).then((res: any) => {
        playerInfo.value = res.data;
        playerShooting.value = res.data.playerShooting;
        playerDefense.value = res.data.playerDefense;
        playerPassing.value = res.data.playerPassing;
        console.log(playerInfo.value);
        console.log(playerPassing.value);
        //取出球员信息
        //导入射门射正次数和进球次数和射失次数
        optionESAG.series[0].data[0].value = res.data.playerShooting.soT;
        optionESAG.series[0].data[1].value = res.data.playerShooting.sh - res.data.playerShooting.soT;
        //导入三区防守数据
        optionED3RD.series[0].data[0].value = res.data.playerDefense.att3rd;
        optionED3RD.series[0].data[1].value = res.data.playerDefense.mid3rd;
        optionED3RD.series[0].data[2].value = res.data.playerDefense.def3rd;
        //导入封堵数据
        optionEBlock.series[0].data[0].value = res.data.playerDefense.shotBlock;
        optionEBlock.series[0].data[1].value = res.data.playerDefense.passBlock;
        //导入对抗数据
        optionECtkl.series[0].data[0].value = res.data.playerDefense.ctkl;
        optionECtkl.series[0].data[1].value = res.data.playerDefense.ctklL
        charshootandgoal();
        chardefense();
        charblock();
        charctkl();
    })
}


</script>