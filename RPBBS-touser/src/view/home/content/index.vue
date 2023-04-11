<template>
  <div class=" flex flex-col">
    <div class="flex  bg-base-100 b-4 ha shadow-xl  w-full my1 px2  rounded-box">
      <div class="avatar p--10 h-30 overflow-hidden items-center rounded">
        <img  v-if="blockimg!=''" :src="blockimg" />
      </div>
      <div class="card-body">
        <h2 class="card-title">{{ blockName }}</h2>
        <!-- <button class="btn btn-xs h-10 sm:btn-sm md:btn-md lg:btn-lg" @click="toEditor()">发帖</button> -->
      </div>
    </div>
    <div class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 rounded-box postcontent h-100vh">
      <div class="flex w-full mx-auto px-0 py-0">
        <div class="flex flex-col w-full h-full">
          <rp-card :useravatar="item.userInfo.avatarPath" :username="item.userInfo.nickname" :liked="false"
            :rank="item.userInfo.level" :id="item.cardId" :block="item.blockInfo.blockName" :title="item.title"
            :richtext="item.richtext" v-for="item in postlist" :key="item.cardId" :piclist="item.sourcePath"
            :comment-num="item.commentNum" :like-num="item.likeNum" :post="item"></rp-card>
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
import { getArticle } from '@/api/post';
import { getUserInfo } from '@/api/user';

//声明帖子列表变数
const postlist: Ref<any> = ref([]);
//声明当前页变数
const page: Ref<number> = ref(1);
//声明分区头图变数，分区名称变数
const blockimg: Ref<string> = ref('');
const block: any = ref(1);
const blockName: any = ref('全部贴文');
//页面加载时执行
onMounted(() => {
  getPostList();
  getArticleList();
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
      blockName.value = res.data.blockName;
    })
  } else {
    console.log('默认分区');
  }
}

//获取帖子列表使用@api中post的getArticle方法
function getArticleList() {
  if (router.currentRoute.value.query.block) {
    block.value = router.currentRoute.value.query.block;
  } else {
    block.value = '';
  }
  getArticle(page.value, 3, block.value).then((res: any) => {
    console.log(res.data.records);
    //向帖子列表的底部增加帖子数据
    postlist.value = postlist.value.concat(res.data.records);

    //如果图片地址是相对路径，需要拼接上服务器地址
    postlist.value.forEach((item: any) => {
      item.sourcePath = item.sourcePath.map((item: any) => {
        if (item.indexOf('http') == -1) {
          return 'http://' + item;
        } else {
          return item;
        }
      })
    })
    //每条帖子的富文本内容，展示40字纯字数，超出部分后续添加省略号，如果不足40字，添加占位空格字符至40字
    postlist.value.forEach((item: any) => {
      item.richtext = item.richtext.replace(/<[^>]+>/g, "");
      if (item.richtext.length > 40) {
        item.richtext = item.richtext.substring(0, 40) + '...';
      } else {
        item.richtext = item.richtext + '                                        ';
      }
    })
    //每条帖子的createById是用户id，需要根据用户id获取用户信息
    postlist.value.forEach((item: any) => {
      getUserInfo(item.createById).then((res: any) => {

        item.userInfo = res.data[0];
        console.log(item.userInfo);
      })
    })
    //每条帖子的blockid是分区id，需要根据分区id获取分区信息
    postlist.value.forEach((item: any) => {
      getBlockDetail(item.blockId).then((res: any) => {
        console.log(res.data);
        item.blockInfo = res.data;
      })
    })
  })
}
//跳转到发帖页面
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
  if (distance == 0) {
    console.log(distance);
    //滚动到底部，加载下一页
    page.value = page.value + 1;
    getArticleList();
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