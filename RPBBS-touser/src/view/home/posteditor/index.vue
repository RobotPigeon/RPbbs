<template>
    <main class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 min-h-100vh rounded-box content">
        <div class="flex w-full mx-auto px-0 py-0">
            <div class="flex flex-wrap w-full h-full flex ">
                <div class="alert shadow-2xl bg-base-100 mt2">
                    <div>
                        <span class="card-title">贴文编辑</span>
                    </div>
                </div>
                <div class="card bg-base-100 shadow-2xl w-full mt2 p2">
                    <label class="label">选择分区</label>
                    <rp-select :options="blocklist.list" v-model="blockName"></rp-select>
                    <!-- <label class="label">帖子类型</label>
                    <rp-select :options="options" v-model="PostType"></rp-select> -->
                    <rp-editor class="min-h-sm mt-2" @contentChanged="handleContentChange"></rp-editor>
                    <rp-upload ref="refupload"/>

                    <button class="btn btn-xs h-10 sm:btn-sm md:btn-md lg:btn-lg mt10" @click="postPost()">发帖</button>
                </div>
            </div>
        </div>

    </main>
</template>

<script setup lang='ts'>
import { ref, reactive, onMounted, onUnmounted } from 'vue'
import type { Ref } from 'vue';
import rpEditor from '@/components/basic/rp-editor.vue';
import rpUpload from '@/components/basic/rp-upload.vue';
import rpSelect from '@/components/basic/rp-select.vue';
import { getBlocklist } from '@/api/block';

//进入编辑器后，获取板块列表/bbs/block/list
//获取板块列表
const blocklist = reactive({
    list: []
}) as any;
onMounted(() => {
    getBlocklist().then((res: any) => {
        //遍历板块列表，将板块id和板块名称放入数组中
        blocklist.list = res.data.records.map((item: any) => {
            return {
                value: item.id,
                label: item.blockName
            }
        });
    })
})
const blockName = ref('')
const PostType = ref('')

const handleContentChange = (newContent: string) => {
    // do something with the new content here
    console.log(newContent)
    
}
function postPost() {
    console.log('发帖');
    //vue3中获取upload组件中defineExpose中的images
    const refupload = ref();
    console.log(refupload);
    
}
</script>