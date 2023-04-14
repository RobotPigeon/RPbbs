<template>
    <!-- Put this part before </body> tag -->
    <input type="checkbox" id="rp-modal" class="modal-toggle" />
    <div class="modal sm:modal-bottom modal-middle rounded-box">
        <div class="modal-box rounded-box">
            <h3 class="font-bold text-lg mb">回复</h3>

            <textarea class="textarea w-full" placeholder="输入回复" v-model="reply.message"></textarea>
            <div class="modal-action">
                <label for="rp-modal" class="btn avatar" @click="sendReply()">发送</label>
                <label for="rp-modal" class="btn mx2 avatar" @click="closeReply()">
                    关闭
                </label>
            </div>

        </div>
    </div>
    <div class="card w-full h-100% bg-base-100 b-1 p2 ">
        <label for="rp-modal" class="btn" @click="startreply()">
            发布回复
        </label>
        <div v-for="comment in comments" :key="comment.id" class="flex justify-start card w-full h-100% bg-base-100  mt2">
            <!-- 遍历评论数据 -->
            <div class=" flex justify-start">
                <label class="btn btn-ghost btn-circle avatar mt2" href="/">
                    <div class="w-12 rounded-full">
                        <img v-if="comment.useravatar!=''" :src="comment.useravatar" alt='avatar' />
                        <img v-else src="@/assets/images/avatar.jpg" alt="">
                    </div>
                </label>
                <div class=" ml-2">
                    <span class="badge badge-accent badge-outline">lv-{{ comment.rank }}</span>
                    <span class="card-title">{{ comment.username }}</span>
                </div>
            </div>
            <div class="content">
                <p class="content m4">{{ comment.message }}</p> <!-- 显示评论内容 -->
                <span class="date justify-end ml4">{{ comment.createTime }}</span>
                <label for="rp-modal" class="justify-end btn  btn-xs btn-outline ml-xl"
                    @click="replycomment(comment)">回复</label>
                <div v-if="comment.cardReplyReplyList.length > 0" class="comments ">
                    <div class="collapse">
                        <input type="checkbox" />
                        <div class="collapse-title color-info justify-end font-medium">
                            展开/收起{{ comment.cardReplyReplyList.length }}条回复
                        </div>
                        <div class="collapse-content">
                            <!-- 如果有楼中楼回复，显示嵌套的评论组件 -->
                            <div v-for="reply in comment.cardReplyReplyList" :key="reply.id"
                                class="comment card bg-base-200 ml-10 p2 b-1">
                                <!-- 遍历楼中楼回复数据 -->
                                <!-- <div class="divider"></div>  -->
                                <div class=" flex justify-start">
                                    <label class="btn btn-ghost btn-circle avatar">
                                        <div class="w-12 rounded-full">
                                            <img v-if="reply.useravatar!=''" :src="reply.useravatar" alt='avatar' />
                                            <img v-else src="@/assets/images/avatar.jpg" alt="">
                                        </div>
                                    </label>
                                    <div class=" ml-2">
                                        <span class="badge badge-accent badge-outline">lv-{{ reply.rank }}</span>
                                        <span class="card-title">{{ reply.username }}</span>
                                    </div>
                                </div>
                                <div class="content">
                                    <p class="content m4"><a class="badge" v-if="reply.replyusername != undefined">@{{
                                        reply.replyusername }}</a> {{reply.message}}
                                    </p> <!-- 显示评论内容 -->
                                    <span class="date justify-end ml4">{{ reply.createTime }}</span>
                                    <label for="rp-modal" class="justify-end btn  btn-xs btn-outline ml-xl"
                                        @click="replycomment(comment)">回复</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup lang="ts">
import router from '@/router';
import { reactive, type PropType } from 'vue';
import useUsersStore from '@/stores/user';
//引入api
import { postReply, postReplyReply } from '@/api/reply';




//创建一级回复标志，如果是一级回复，reply.replyToId为空，如果是楼中楼回复，reply.replyToId为一级回复的id

const reply = reactive({
    message: '' as string,
    createById: '' as any,
    cardId: '' as any,
    replyId: '' as any,
    replyToId: '' as any,
});

//startreply方法，获取当前链接的postid，将id赋值给reply.cardId
function startreply() {
    const params = router.currentRoute.value.query;
    reply.cardId = params.postid;
    //获取当前登录用户的id
    reply.createById = useUsersStore().getUser;
    console.log(reply);
}
//二级回复方法
function replycomment(comment: any) {
    reply.replyToId = comment.createById;
    reply.replyId = comment.id;
    startreply()
}

//关闭回复框，清空回复reply
function closeReply() {
    reply.message = '';
    reply.replyToId = '';
}
//发送回复
function sendReply() {
    console.log(reply);
    //如果是一级回复，reply.replyToId为空，如果是楼中楼回复，reply.replyToId为一级回复的id，一级回复调用一级回复接口，楼中楼回复调用楼中楼回复接口
    if (reply.replyToId == '') {
        //调用一级回复接口，@api中/card_center/reply接口
        postReply(reply).then((res) => {
            console.log(res);
        });
    } else {
        //调用楼中楼回复接口
        postReplyReply(reply).then((res) => {
            console.log(res);
        });
    }
    //关闭回复框
    closeReply();
    //刷新页面
    router.go(0);
}

const props = defineProps<{
    comments: any;
}>();
</script>
