<template>
    <nav class="flex w-1/3 h-full">
        <div class="w-full flex mx-auto px-6 py-18">
            <div class="w-1/2 h-full flex flex-col-reverse">
                <img class=" w" src="@/assets/images/yada.gif" alt="">
                <rpfooter></rpfooter>

            </div>
            
        </div>
    </nav>
</template>
    
<script setup lang='ts'>
import { ref, reactive } from 'vue';
import rpfooter from '@/components/basic/RP-footer.vue'

</script>
    
<style scoped lang='less'>

</style>