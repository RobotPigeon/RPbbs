<template>
    <div class="flex w-full h-a items-center justify-center pb-4">
        <div class="card w-full h-100% bg-base-100 b-1">
            <div class="card-body h-a">
                <label tabindex="0" class="btn btn-ghost btn-circle avatar">
                    <div class="w-10 rounded-full">
                        <img src="https://lain.bgm.tv/r/400/pic/cover/l/85/aa/268279_9rynK.jpg" alt='avatr' />
                    </div>
                </label>
                <h2 class="card-title">电锯人捏</h2>
                <p>嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟</p>
            </div>
            <rpCarousel :list="piclist"></rpCarousel>
            <div class="w-100%">点赞</div>
        </div>
    </div>
</template>
<script lang="ts" setup>
import rpCarousel from '@/components/basic/rp-carousel.vue';
const piclist:object=['https://lain.bgm.tv/r/400/pic/cover/l/a4/16/296739_71dLe.jpg','https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg','https://lain.bgm.tv/pic/cover/l/64/f0/420030_R3z00.jpg','https://lain.bgm.tv/r/400/pic/cover/l/85/aa/268279_9rynK.jpg','https://lain.bgm.tv/r/400/pic/cover/l/4a/27/300648_0ABJ3.jpg','https://lain.bgm.tv/r/400/pic/cover/l/7e/ca/378862_PSRrl.jpg']
</script>
<style lang="">
</style>
