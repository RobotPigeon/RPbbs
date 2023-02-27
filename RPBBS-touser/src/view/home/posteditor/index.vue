<template>
    <main class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 min-h-100vh rounded-box content">
        <div class="flex w-full mx-auto px-0 py-0">
            <div class="flex flex-wrap w-full h-full flex ">
                <div class="alert shadow-2xl bg-base-100 mt2">
                    <div>
                        <span class="card-title">贴文编辑</span>
                    </div>
                </div>
                <rp-upload></rp-upload>
                <rp-editor class="min-h-30" @contentChanged="handleContentChange"></rp-editor>
            </div>
        </div>

    </main>
</template>
  
<script setup lang='ts'>
import { ref, reactive, onMounted, onUnmounted } from 'vue'
import type { Ref } from 'vue';
import rpEditor from '@/components/basic/rp-editor.vue';
import rpUpload from '@/components/basic/rp-upload.vue';

const title: string = '如何评价首先是然后再是'
const useravatar: string = 'https://lain.bgm.tv/r/400/pic/cover/l/a4/16/296739_71dLe.jpg'
const text: string = '啊啊啊啊啊啊啊啊啊啊啊啊啊啊'

const handleContentChange = (newContent: string) => {
    // do something with the new content here
    console.log(newContent)
}
</script>
  
<style scoped lang='less'></style>