<template>
    <div class="card w-full h-100% bg-base-100 b-1 p2 ">
        <div v-for="comment in comments" :key="comment.id" class="flex justify-start card w-full h-100% bg-base-100  mt2">
            <!-- 遍历评论数据 -->
            <div class=" flex justify-start">
                <label class="btn btn-ghost btn-circle avatar mt2" href="/">
                    <div class="w-12 rounded-full">
                        <img :src="comment.avatar" alt='avatar' />
                    </div>
                </label>
                <div class="mt ml-2">
                    <span class="badge badge-accent badge-outline">lv-{{ comment.rank }}</span>
                    <span class="card-title">{{ comment.author }}</span>
                </div>
            </div>
            <div class="content">
                <p class="content m4">{{ comment.content }}</p> <!-- 显示评论内容 -->
                <span class="date justify-end ml4">{{ comment.date }}</span>
                <div v-if="comment.replies.length > 0" class="comments"> <!-- 如果有楼中楼回复，显示嵌套的评论组件 -->
                    <div v-for="reply in comment.replies" :key="reply.id" class="comment card bg-base-200 ml-10 p2 b-1">
                        <!-- 遍历楼中楼回复数据 -->
                        <!-- <div class="divider"></div>  -->
                        <div class=" flex justify-start">
                            <label class="btn btn-ghost btn-circle avatar">
                                <div class="w-12 rounded-full">
                                    <img :src="reply.avatar" alt='avatar' />
                                </div>
                            </label>
                            <div class="mt ml-2">
                                <span class="badge badge-accent badge-outline">lv-{{ reply.rank }}</span>
                                <span class="card-title">{{ reply.author }}</span>
                            </div>
                        </div>
                        <div class="content">
                            <p class="content m4"><a class="badge" v-if="reply.replyperson != undefined"
                                    :href="reply.replyperson.id">@{{ reply.replyperson.username }}</a> {{ reply.content }}
                            </p> <!-- 显示评论内容 -->
                            <span class="date justify-end ml4">{{ reply.date }}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup lang="ts">
import { defineProps } from "vue";
interface Comment {
    id: number; // 评论id
    avatar: string; // 评论者头像
    author: string; // 评论者昵称
    date: string; // 评论日期
    rank: string;
    content: string; // 评论内容
    replyperson?: Array<{ id: string; username: string }>[0] | undefined;
    replies: Comment[]; // 楼中楼回复列表
}
const props = defineProps({
    comments: Array<Comment> // 定义一个数组类型的prop，用于传入评论数据
});
</script>
