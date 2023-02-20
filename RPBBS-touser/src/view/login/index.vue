<template lang="">
<div class="hero min-h-screen bg-base-100">
    <div class="hero-content flex-col lg:flex-row-reverse bg-base-100 card">
        <div class="text-center lg:text-left">
        <h1 class="text-5xl font-bold">让我们开始吧!</h1>
        <p class="py-6">登录我们的网站，欣赏更多内容，在RPBBS探索一切新鲜事物吧！Log in to our website, enjoy more content, and explore all new things in rpbbs!</p>
        </div>
        <div class="card flex-shrink-0 w-full max-w-sm shadow-2xl">
        <div class="card-body">
            <div class="form-control">
            <label class="label">
                <span class="label-text">电子邮箱or用户名</span>
            </label>
            <input type="text" placeholder="请输入邮箱或者用户名" class="input input-bordered" />
            </div>
            <div class="form-control">
            <label class="label">
                <span class="label-text">密码</span>
            </label>
            <input type="text" placeholder="请输入密码" class="input input-bordered" />
            <label class="label">
                <a href="#" class="label-text-alt link link-hover">忘记密码?</a>
            </label>
            </div>
            <div class="form-control mt-6">
            <button class="btn btn-primary">登录</button>
            </div>
        </div>
        </div>
    </div>
</div>
</template>
<script setup lang='ts'>
import { ref, reactive } from 'vue'
</script>
<style lang="less">
.hero{
    background-image:url('@/assets/images/background.jpg');
}
</style>