<template>
  <main class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 rounded-box" >
        <div class="flex w-full mx-auto px-0 py-0">
          <div class="flex flex-col w-full h-full">
            <rpCard></rpCard>
            <rpCard></rpCard>
            <rpCard></rpCard>
            <rpCard></rpCard>
            <rpCard></rpCard>
            <rpCard></rpCard>
            <rpCard></rpCard>
            <rpCard></rpCard>
            <rpCard></rpCard>
            <rpCard></rpCard>
          </div>
        </div>
        
      </main>

</template>

<script setup lang='ts'>
import { ref, reactive } from 'vue'
import rpCard from '@/components/basic/rp-card.vue';
</script>

<style scoped lang='less'>

</style>