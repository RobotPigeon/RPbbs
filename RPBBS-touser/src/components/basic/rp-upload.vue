<template>
    <div class="container">
        <h1>图片上传组件</h1>
        <div class="form-group">
            <input type="file" id="file" accept="image/*" multiple @change="handleUpload"
                class="file-input file-input-bordered w-full max-w-xs" />
        </div>
        <div v-if="uploading" class="progress-group">
            <div v-for="(item, index) in uploadFiles" :key="index" class="flex items-center justify-between mb-2">
                <span>{{ item.name }}</span>
                <v-progress-linear :value="item.progress" height="10" color="#4CAF50" rounded></v-progress-linear>
            </div>
        </div>
        <div v-if="message == '上传成功'" class="alert alert-success mt-3">
            {{ message }}
        </div>
        <div v-if="message != '' && message != '上传成功'" class="alert alert-error mt-3">
            {{ message }}
        </div>
        <h2>已上传文件</h2>
        <ul class="list-group mt-3 grid grid-cols-3 gap-4">
            <li v-for="(image, index) in images" :key="index" class="">
                <img :src="image.indexOf('http://') == -1 ? 'http://'+image : image" class="w-full h-48 object-cover">
            </li>
        </ul>
        <div class="h-20"></div>
    </div>
</template>

<script lang='ts' setup >
import { ref } from "vue";
import { postArticleFile } from "@/api/post";

const uploadFiles: any = ref([]);
const uploading = ref(false);
const message = ref("");
const images: any = ref([]);
// 上传文件
const handleUpload = (event: any) => {
    let selectedFiles = event.target.files;
    if (!selectedFiles) {
        return;
    }
    uploading.value = true;
    for (let i = 0; i < selectedFiles.length; i++) {
        console.log(i, selectedFiles[i]);
        uploadFiles.value.push(selectedFiles[i]);
        //限制上传文件类型
        if (selectedFiles[i].type.indexOf("image") === -1) {
            message.value = "只能上传图片";
            uploading.value = false;
            return;
        }
        //上传文件
        var data = new FormData();
        data.append('file', selectedFiles[i]);
        //使用@api/post.js中的postArticleFile方法
        postArticleFile(data).then((res: any) => {
            console.log(res);
            //将上传成功的图片地址的斜杠替换为反方向斜杠然后放入images数组中
            res.msg = res.msg.replace(/\\/g, "/");
            images.value.push(res.msg);
            message.value = "上传成功";
            uploading.value = false;
            //上传成功后清空上传文件，定时消失提示信息
            uploadFiles.value = [];
            setTimeout(() => {
                message.value = "";
            }, 500);
        })
    }
};
</script>