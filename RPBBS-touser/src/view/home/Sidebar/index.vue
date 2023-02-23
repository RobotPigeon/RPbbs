<template>
  <nav class="flex max-w-1/2 min-w-60 h-full ml-8xl p-l-80">
    <div class="w-full mx-auto px-6 py-1">
      <rpmenu :tablist="maintablist"></rpmenu>
      <rpmenu class="mt-2" :tablist="areatablist" v-if="!areatablist"></rpmenu>
    </div>
  </nav>
</template>

<script setup lang="ts">
import { ref, reactive } from "vue";
import rpmenu from "@/components/basic/rp-menu.vue";
const maintablist = reactive([
  {
    icon: "M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6",
    text: "主页",
    path: "/home"
  },
  {
    icon: "M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z",
    text: "热门板块",
    path: "/home/Partition"
  },
]);
const areatablist = reactive([
]);
</script>

<style scoped lang="less"></style>
