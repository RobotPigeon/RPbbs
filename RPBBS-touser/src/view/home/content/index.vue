<template>
  <div class=" flex flex-col">
    <div class="flex  bg-base-100 b-4 ha shadow-xl  w-full my1 px2  rounded-box">
      <div class="avatar p--10 h-30 overflow-hidden items-center rounded">
        <img :src="blockimg" />
      </div>
      <div class="card-body">
        <h2 class="card-title">{{ block }}</h2>
        <button class="btn btn-xs h-10 sm:btn-sm md:btn-md lg:btn-lg" @click="toEditor()">发帖</button>
      </div>
    </div>
    <div class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 rounded-box postcontent h-100vh">
      <div class="flex w-full mx-auto px-0 py-0">
        <div class="flex flex-col w-full h-full">
          <rpCard :username="username" :liked="true" :like-num="10000" :comment-num="10000" :richtext="text"
            :useravatar="useravatar" :rank="rank" :piclist="piclist" :title="title" :block="block"></rpCard>
          <rpCard :username="username" :liked="true" :like-num="10000" :comment-num="10000" :richtext="text"
            :useravatar="useravatar" :rank="rank" :piclist="piclist" :title="title" :block="block"></rpCard>
          <rpCard :username="username" :liked="true" :like-num="10000" :comment-num="10000" :richtext="text"
            :useravatar="useravatar" :rank="rank" :piclist="piclist" :title="title" :block="block"></rpCard>
          <rpCard :username="username" :liked="true" :like-num="10000" :comment-num="10000" :richtext="text"
            :useravatar="useravatar" :rank="rank" :piclist="piclist" :title="title" :block="block"></rpCard>
          <rpCard :username="username" :liked="true" :like-num="10000" :comment-num="10000" :richtext="text"
            :useravatar="useravatar" :rank="rank" :piclist="piclist" :title="title" :block="block"></rpCard>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang='ts'>
import { ref, reactive, onMounted, onUnmounted } from 'vue'
import type { Ref } from 'vue';
import rpCard from '@/components/basic/rp-card.vue';
import rpEditor from '@/components/basic/rp-editor.vue';
import router from '@/router';
import { getBlockDetail } from '@/api/block';
const loadflag: Ref<boolean> = ref(false);
const piclist: Array<string> = ['https://lain.bgm.tv/r/400/pic/cover/l/a4/16/296739_71dLe.jpg', 'https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg', 'https://lain.bgm.tv/pic/cover/l/64/f0/420030_R3z00.jpg', 'https://lain.bgm.tv/pic/cover/l/64/f0/420030_R3z00.jpg']
const username: string = '猪逼巴巴'
const title: string = '如何评价首先是首先是首先是'
const useravatar: string = 'https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg'
const rank: number = 99
const text: string = '<p>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</p><p>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</p>'

//声明分区头图变数，分区名称变数
const blockimg: Ref<string> = ref('https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg');
const block: Ref<string> = ref('默认分区');
//页面加载时执行
onMounted(() => {
  getPostList();
});

//进入页面后，获取链接参数，有参数获取分区帖子数据，无参数获取默认帖子分页
function getPostList() {
  const query = router.currentRoute.value.query;
  if (query.block) {
    //根据id获取分区详情
    console.log(query.block);
    getBlockDetail(query.block).then((res: any) => {
      console.log(res.data);
      blockimg.value = res.data.picPath;
      block.value = res.data.blockName;
    })
  } else {
    console.log('默认分区');
  }
}


function toEditor() {
  router.push({ path: "/home/posteditor" });
}

//监听滚动方法
function scrollHandle() {
  const postcontent = document.getElementsByClassName('postcontent')[0];
  const scrollHeight = postcontent.scrollHeight
  const scrollTop = postcontent.scrollTop
  const clientHeight = postcontent.clientHeight;
  const distance = scrollHeight - scrollTop - clientHeight;
  if (distance <= 200) {
    console.log(distance);

  }
}

onMounted(() => {
  //组件挂载时，添加scroll监听
  const postcontent = document.getElementsByClassName('postcontent')[0];
  postcontent.addEventListener("scroll", scrollHandle, true);
});
// onUnmounted(() => {
//   //组件卸载时，停止监听
//   const postcontent = document.getElementsByClassName('postcontent')[0];
//   postcontent.removeEventListener("scroll", scrollHandle, false);
// });

</script>

<style scoped lang='less'></style>