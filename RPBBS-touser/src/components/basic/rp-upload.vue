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
        <div v-if="message" class="alert alert-success mt-3">
            {{ message }}
        </div>
        <h2>已上传文件</h2>
        <ul class="list-group mt-3 grid grid-cols-3 gap-4">
            <li v-for="(image, index) in images" :key="index" class="">
                <img :src="'data:image/png;base64,' + image.data" width="" height="" class="" />
            </li>
        </ul>
    </div>
</template>

<script lang='ts' setup >
import { ref } from "vue";

const uploadFiles: any = ref([]);
const uploading = ref(false);
const message = ref("");
const images: any = ref([]);

const handleUpload = (event: any) => {
    let selectedFiles = event.target.files;
    if (!selectedFiles) {
        return;
    }
    uploading.value = true;
    for (let i = 0; i < selectedFiles.length; i++) {
        console.log(i, selectedFiles[i]);
        // upload(i, selectedFiles[i]);
    }
};

// const upload = (idx: number, file: { name: any; }) => {
//     let _progress = { name: file.name, progress: 0 };
//     uploadFiles.value.push(_progress);

//     let formData = new FormData();
//     post("http://localhost:3000/upload", FormData, {
//         headers: {
//             "Content-Type": "multipart/form-data",
//         },
//         onUploadProgress: (event: { loaded: number; total: number; }) => {
//             let progress = Math.round((event.loaded * 100) / event.total);
//             uploadFiles.value[idx].progress = progress;
//         },
//     })
//     .then((response: { data: any; }) => {
//         let image = response.data;
//         images.value.push(image);
//         uploadFiles.value = [];
//         message.value = "上传成功";
//     })
//     .catch((error: any) => {
//         console.error(error);
//         message.value = "上传失败";
//     });
// const uploading = computed(() => {
//     return uploadFiles.value.some((item: { progress: number; }) => item.progress < 100);
// });
</script>