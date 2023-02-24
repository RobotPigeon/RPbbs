<template>
  <main class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 rounded-box content min-h-100vh">
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

  </main>
</template>

<script setup lang='ts'>
import { ref, reactive, onMounted, onUnmounted } from 'vue'
import type { Ref } from 'vue';
import rpCard from '@/components/basic/rp-card.vue';
const loadflag: Ref<boolean> = ref(false);
const piclist: Array<string> = ['https://lain.bgm.tv/r/400/pic/cover/l/a4/16/296739_71dLe.jpg', 'https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg', 'https://lain.bgm.tv/pic/cover/l/64/f0/420030_R3z00.jpg', 'https://lain.bgm.tv/pic/cover/l/64/f0/420030_R3z00.jpg']
const username: string = '猪逼巴巴'
const title: string = '如何评价首先是然后再是'
const useravatar: string = 'https://lain.bgm.tv/r/400/pic/cover/l/a4/16/296739_71dLe.jpg'
const rank: number = 99
const text: string = '<p>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</p><p>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</p>'
const block:string = '逆天板块'

//监听滚动方法
function scrollHandle() {
  const content = document.getElementsByClassName('content')[0];
  const scrollHeight = content.scrollHeight
  const scrollTop = content.scrollTop
  const clientHeight = content.clientHeight;
  const distance = scrollHeight - scrollTop - clientHeight;
  if (distance <= 200) {
    console.log(distance);

  }
}

onMounted(() => {
  //组件挂载时，添加scroll监听
  const content = document.getElementsByClassName('content')[0];
  content.addEventListener("scroll", scrollHandle, true);
});
onUnmounted(() => {
  //组件卸载时，停止监听
  const content = document.getElementsByClassName('content')[0];
  content.removeEventListener("scroll", scrollHandle, false);
});

</script>

<style scoped lang='less'></style>