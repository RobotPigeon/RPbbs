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
                    <rp-detailcard :username="username" :liked="true" :like-num="10000" :comment-num="10000"
                        :richtext="text" :useravatar="useravatar" :rank="rank" :piclist="piclist" :title="title"
                        :block="block"></rp-detailcard>
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
const loadflag: Ref<boolean> = ref(false);
const piclist: Array<string> = ['https://lain.bgm.tv/r/400/pic/cover/l/a4/16/296739_71dLe.jpg', 'https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg', 'https://lain.bgm.tv/pic/cover/l/64/f0/420030_R3z00.jpg', 'https://lain.bgm.tv/pic/cover/l/64/f0/420030_R3z00.jpg']
const username: string = '猪逼巴巴'
const title: string = '如何评价首先是然后再是'
const useravatar: string = 'https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg'
const rank: number = 99
const text: string = '<p>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</p><p>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</p>'
const block: string = '逆天板块'
const comments = [ // 父组件的评论数据
    {
        id: 1,
        rank: 1,
        avatar: "https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg",
        author: "User1",
        date: "2023-02-28",
        content: "This is a comment.",
        replies: [
            {
                id: 2,
                avatar: "https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg",
                author: "User2",
                rank: 1,
                date: "2023-02-28",
                content: "This is a reply.",
                replyperson: {
                    username: 'user1',
                    id: '1111111'
                },
                replies: []
            }, {
                id: 5,
                rank: 1,
                avatar: "https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg",
                author: "User2",
                date: "2023-02-28",
                content: "This is a reply.",
                replyperson: {
                    username: 'user1',
                    id: '1111111'
                },
                replies: []
            }
        ]
    },
    {
        id: 3,
        rank: 1,
        avatar: "https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg",
        author: "User3",
        date: "2023-02-28",
        content:
            "This is another comment with a long text to test the layout and style of the component.",
        replies: [
            {
                id: 4,
                rank: 1,
                avatar: "https://lain.bgm.tv/pic/cover/l/2b/03/406604_iYYvi.jpg",
                author: "User4",
                date: "2023-02-28",
                content:
                    "This is another reply with a long text to test the layout and style of the component.",
                replyperson: {
                    username: 'user1',
                    id: '1111111'
                },
                replies: []

            }
        ]
    },
]

function toEditor() {
    router.push({ path: "/home/posteditor" });
}
//跳转进入该页面时，获取路由参数
function getParams() {
    const params = router.currentRoute.value.query;
    console.log(params.postid);
}

//监听滚动方法
function scrollHandle() {
    const postcontent = document.getElementsByClassName('postcontent')[0];
    const scrollHeight = postcontent.scrollHeight
    const scrollTop = postcontent.scrollTop
    const clientHeight = postcontent.clientHeight;
    const distance = scrollHeight - scrollTop - clientHeight;
    if (distance <= 200) {
        console.log(distance);

    }
}

onMounted(() => {
    getParams();
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