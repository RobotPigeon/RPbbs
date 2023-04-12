<template>
    <main class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 min-h-100vh rounded-box content">
        <div class="flex w-full mx-auto px-0 py-0">
            <div class="flex flex-wrap w-full h-full flex ">
                <div class="alert shadow-2xl bg-base-100 mt2">
                    <div>
                        <span class="card-title">贴文编辑</span>
                    </div>
                </div>
                <div class="card bg-base-100 w-full h-a mt2 p2">
                    <label class="label">贴文标题</label>
                    <rp-input type="text" v-model="post.title" required errorValue="请输入标题"></rp-input>
                    <label class="label">选择分区</label>
                    <rp-select :options="blocklist.list" v-model="post.blockId"></rp-select>
                    <!-- <label class="label">帖子类型</label>
                    <rp-select :options="options" v-model="PostType"></rp-select> -->
                    <label class="label">贴文编辑</label>
                    <rp-editor class="min-h-sm mt-2" @contentChanged="handleContentChange"></rp-editor>
                    <label class="label">贴文图片</label>
                    <rp-upload @upload="handleUpload"></rp-upload>
                    <div class="fixed bottom-0 right-0 mb-4 mr-4">
                        <button class="btn btn-primary btn-lg h-10" @click="postPost()">点击发布帖文</button>
                    </div>

                </div>

            </div>
        </div>

    </main>
</template>

<script setup lang='ts'>
import { ref, reactive, onMounted } from 'vue'
import type { Ref } from 'vue';
import rpEditor from '@/components/basic/rp-editor.vue';
import rpUpload from '@/components/basic/rp-upload.vue';
import rpSelect from '@/components/basic/rp-select.vue';
import useAlertStore from '@/stores/alert';
import useUserStore from "@/stores/user";
import rpInput from '@/components/basic/rp-input.vue';
import { getBlocklist } from '@/api/block';
import { postArticle } from '@/api/post';
import router from '@/router';

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
    //获取当前用户信息从pinia中获取
    const user = useUserStore().getUser;
    //将用户信息放入帖子中
    post.createById = user;
    //帖子类型默认为1
    post.cardTypeId = 1;

})
//创建帖子类
const post = reactive({
    title: '',
    message: '',
    createById: '',
    blockId: '',
    status: '',
    cardTypeId: '',
    likeNum: '',
    richtext: '',
    sourcePath: '',
    sourceFile: ''
}) as any;


//handleUpload接收upload的emit事件
const handleUpload = (url: string) => {
    //将images放入帖子图片数组中
    post.sourcePath = url;
}

const handleContentChange = (newContent: string) => {
    post.richtext = newContent;

}
const postPost = () => {
    //发帖前检查是否该填的填了，同时富文本不带标签的字数实际字数是否大于50字
    if (post.title == '' || post.richtext == '' || post.blockId == '') {
        //使用showalert组件
        useAlertStore().setAlert({ message: "请填写完整内容", type: "error" });
        return;
    }
    // if (post.richtext.replace(/<[^>]+>/g, "").length < 50) {
    //     useAlertStore().setAlert({ message: "请填写至少50字的内容", type: "error" });
    //     return;
    // }
    //帖子类型默认为1
    post.cardTypeId = 1;
    //发帖前遍历帖子图片数组，将图片数组每条数据只保留/img/xxxx.jpg,不保留/img/之前的内容
    // post.sourcePath = post.sourcePath.map((item: any) => {
    //     return item.replace(/.*\/img\//, "/img/");
    // })
    console.log(post);
    //调用发帖接口,@/api中的post.ts
    postArticle(post).then((res: any) => {
        console.log(res);
        if (res.code == 200) {
            useAlertStore().setAlert({ message: "发帖成功", type: "success" });
            //跳转到首页
            router.push({ name: "content" });
        }
    })

}
</script>