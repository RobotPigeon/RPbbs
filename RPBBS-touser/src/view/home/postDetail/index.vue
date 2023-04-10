<template>
    <div class="flex b-1 shadow-xl  w-full rounded-box flex-col flex">
        <div class="alert shadow-2xl  bg-base-100">
            <div>
                <span class="card-title h-2vh">贴文详情</span>
            </div>
        </div>
        <div class="flex flex-col w-full overflow-y-auto mb-18 mt-1 b-1 rounded-box postcontent h-90vh">
            <div class="flex w-full mx-auto px-0 py-0">
                <div class="flex flex-col w-full h-full">
                    <rp-detailcard :username="postDetail.username" :liked="true" :like-num="10000" :comment-num="10000"
                        :richtext="postDetail.text" :useravatar="postDetail.useravatar" :rank="postDetail.rank"
                        :piclist="postDetail.piclist" :title="postDetail.title"
                        :block="postDetail.blockName"></rp-detailcard>
                    <div class="alert shadow-2xl  b-1 bg-base-100">
                        <div>
                            <span class="card-title">回复</span>
                        </div>

                    </div>
                    <rp-comments :comments="comments"></rp-comments>
                </div>
            </div>
        </div>
    </div>
</template>
  
<script setup lang='ts'>
import { ref, reactive, onMounted, onUnmounted } from 'vue'
import type { Ref } from 'vue';
import rpDetailcard from '@/components/basic/rp-detailcard.vue';
import rpComments from '@/components/basic/rp-comments.vue';
import router from '@/router';
//调用api
import { getArticleDetail, getArticleBaseInfo } from '@/api/post';
import { getUserInfo } from '@/api/user';
import { getBlockDetail } from '@/api/block';
import { getReply } from '@/api/reply';
const loadflag: Ref<boolean> = ref(false);
//根据上方数据结构，创建帖子详情变数
const postDetail = reactive({
    username: '',
    title: '',
    useravatar: '',
    rank: 0,
    text: '',
    blockId: '',
    blockName: '',
    piclist: [],
});
//创建评论变量
const comments: any = ref([]);
//创建贴文创建者id变量
const createById: any = ref('');

//跳转进入该页面时，获取路由参数
function getParams() {
    const params = router.currentRoute.value.query;
    console.log(params.postid);
}

//根据postid获取帖子详情和基本信息
function getPostDetail() {
    const params: any = router.currentRoute.value.query;
    //调用@api中的两个接口getArticleDetail,getArticleBaseInfo
    getArticleDetail(params.postid).then(res => {
        console.log(res);
        //将获取到的数据赋值给postDetail
        postDetail.text = res.data.richtext;
        //res.data.sourcePath按分号分割成数组，去除最后一个空元素
        postDetail.piclist = res.data.sourcePath.split(';').slice(0, -1);
        console.log(postDetail.piclist);

    })

    getArticleBaseInfo(params.postid).then(res => {
        console.log(res);
        postDetail.title = res.data.title;
        getUserInfo(res.data.createById).then(res => {
            console.log(createById.value);
            postDetail.username = res.data[0].nickname;
            postDetail.useravatar = res.data[0].avatarPath
                ;
            postDetail.rank = res.data[0].level;
        })
        getBlockDetail(res.data.blockId).then(res => {
            console.log(res);
            postDetail.blockName = res.data.blockName;
        })
    })
    //创建page变量，用于分页
    getComments(1);
}

//根据postid获取评论
function getComments(page: number) {
    const params: any = router.currentRoute.value.query;
    //根据取得的params.postid，调用评论接口，获取评论数据
    getReply(page, 10, params.postid).then(res => {
        console.log(res.data.records);
        comments.value = res.data.records;
        //根据res.data.records.createById，调用用户接口，获取用户信息
        for (const element of comments.value) {
            getUserInfo(element.createById).then(res => {
                element.username = res.data[0].nickname;
                element.useravatar = res.data[0].avatarPath;
                element.rank = res.data[0].level;
            })
        }
    })
}

//监听滚动方法
function scrollHandle() {
    const postcontent = document.getElementsByClassName('postcontent')[0];
    const scrollHeight = postcontent.scrollHeight
    const scrollTop = postcontent.scrollTop
    const clientHeight = postcontent.clientHeight;
    const distance = scrollHeight - scrollTop - clientHeight;
    const page = ref(2);
    if (distance == 0) {
        //滚动到底部，加载更多
        if (!loadflag.value) {
            loadflag.value = true;
            //调用分页接口，获取下一页数据
            getComments(page.value);
            loadflag.value = false;
            page.value++;
        }

    }
}

onMounted(() => {
    getParams();
    getPostDetail();
    //组件挂载时，添加scroll监听
    const postcontent = document.getElementsByClassName('postcontent')[0];
    postcontent.addEventListener("scroll", scrollHandle, true);
});
  // onUnmounted(() => {
  //   //组件卸载时，停止监听
  //   const postcontent = document.getElementsByClassName('postcontent')[0];
  //   postcontent.removeEventListener("scroll", scrollHandle, false);
  // });

</script>
  
<style scoped lang='less'></style>