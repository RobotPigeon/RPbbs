<template>
    <div class=" flex flex-col">
        <div class="flex  bg-base-100 b2  ha shadow-xl  w-full my1 px2  rounded-box">
            <div class="h-a items-center mb1 w-full flex">
                <div class="form-control w-95%">
                    <input type="text" placeholder="Search" class="input input-bordered" />
                </div>
                <button class="btn btn-ghost btn-circle">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
                    </svg>
                </button>
            </div>
        </div>
        <div class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 rounded-box postcontent h-100vh">
            <div class="flex w-full mx-auto px-0 py-0">
                <div v-if="postlist.length != 0" class="items-center justify-center h-full  m10">
                    <div text-6xl>loading...</div>
                </div>
                <div class="grid grid-cols-3 w-full h-full m2 p2 ">
                    <div class="card w-a h-a bg-base-100 shadow-xl m2" v-for="item in 10">
                        <figure><img src="https://lain.bgm.tv/pic/cover/l/83/cf/304217_Yu97O.jpg" alt="Shoes" />
                        </figure>
                        <div class="card-body">
                            <h3 class="card-title">
                                红发女郎
                            </h3>
                            <p>超级二次元啊</p>
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
import rpSelect from '@/components/basic/rp-select.vue';

//创建日期变数
const startDate: any = ref('');
const endDate: any = ref('');

//声明帖子列表变数
const postlist: Ref<any> = ref([]);
//声明当前页变数
const page: Ref<number> = ref(1);
//声明分区头图变数，分区名称变数
const blockimg: Ref<string> = ref('https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg');
const block: any = ref(1);
const blockName: any = ref('玩家论坛');
//页面加载时执行
onMounted(() => {

});
//选择器示例数据
const options = [
    { value: 1, label: '玩家装备' },
    { value: 2, label: '游戏攻略' },
    { value: 3, label: '游戏新闻' },
    { value: 4, label: '游戏评测' },
]

//监听滚动方法
function scrollHandle() {
    const postcontent = document.getElementsByClassName('postcontent')[0];
    const scrollHeight = postcontent.scrollHeight
    const scrollTop = postcontent.scrollTop
    const clientHeight = postcontent.clientHeight;
    const distance = scrollHeight - scrollTop - clientHeight;
    if (distance == 0) {
        console.log(distance);
        //滚动到底部，加载下一页
        page.value = page.value + 1;
        // get();
    }
}

onMounted(() => {
    //组件挂载时，添加scroll监听
    const postcontent = document.getElementsByClassName('postcontent')[0];
    postcontent.addEventListener("scroll", scrollHandle, true);
});


</script>