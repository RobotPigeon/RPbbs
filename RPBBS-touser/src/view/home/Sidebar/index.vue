<template>
  <nav class="flex  h-full  p-l-30">
    <div class="w-full mx-auto px-6 py-1 flex flex-col">
      <div class="card w-56 bg-base-100 shadow-xl">
        <figure class="px-10 pt-10">
          <img :src="user.useravatar" alt="头像" class="rounded-xl" />
        </figure>
        <div class="card-body items-center text-center">
          <h2 class="card-title">{{user.username}}</h2>
          <p>快点发帖加入进来?</p>
          <div class="card-actions">
            <button class="btn btn-primary" @click="toedtior()">发布贴文</button>
          </div>
        </div>
      </div>
    </div>
  </nav>
</template>

<script setup lang="ts">
import { ref, reactive ,onMounted} from "vue";
import rpmenu from "@/components/basic/rp-menu.vue";
import {getUserInfo} from "@/api/user";
import useUserStore   from "@/stores/user";
import router from "@/router";
//页面加载时获取用户信息
onMounted(getuserinfo)
//创建用户信息变数
const user = reactive({
  username: "admin",
  useravatar: "",
  rank: 1,
});
//获取用户信息@api/user/getuserinfo
function getuserinfo() {
  //TODO
  //获取当前用户id使用pinia
    let id = useUserStore().getUser

  getUserInfo(id).then((res) => {
    console.log("获取用户信息");
    
    console.log(res);
    user.username = res.data[0].nickname;
    user.useravatar = res.data[0].avatarPath;
    user.rank = res.data[0].level;
  });
}
//跳转到编辑器
function toedtior() {
  router.push("/home/posteditor");
}

const areatablist = reactive([
]);
</script>

<style scoped lang="less"></style>
