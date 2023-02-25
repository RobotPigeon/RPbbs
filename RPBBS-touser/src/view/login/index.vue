<template lang="">
<div class="hero login min-h-screen bg-base-100">
    <div class="hero-content flex-col lg:flex-row-reverse bg-base-100 card">
        <div class="text-center lg:text-left">
        <h1 class="text-5xl font-bold">让我们开始吧!</h1>
        <p class="py-6">登录我们的网站，欣赏更多内容，在RPBBS探索一切新鲜事物吧！Log in to our website, enjoy more content, and explore all new things in rpbbs!</p>
        </div>
        <div class="card flex-shrink-0 w-full max-w-sm shadow-2xl">
        <div class="card-body">
            <div class="form-control">
            <label class="label">
                <span class="label-text">电子邮箱</span>
            </label>
            <rp-input type="text" errorValue='请输入正确的邮箱' :required="true" :pattern='/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/' @change="handleInputChange"></rp-input>
            </div>
            <div class="form-control">
            <label class="label">
                <span class="label-text">密码</span>
            </label>
                <!-- 如果showPwd为true，则显示type为text的输入框 -->
                <rp-input v-if="showPwd" type="text" errorValue='请输入正确的密码' :required="true" :pattern='/^\S*(?=\S{6,})(?=\S*\d)(?=\S*[A-Z])(?=\S*[a-z])(?=\S*[!@#$%^&*? ])\S*$/' @change="handleInputChange"></rp-input>
                <!-- 如果showPwd为false，则显示type为password的输入框 -->
                <rp-input v-else type="password" errorValue='请输入正确的密码' :required="true" :pattern='/^\S*(?=\S{6,})(?=\S*\d)(?=\S*[A-Z])(?=\S*[a-z])(?=\S*[!@#$%^&*? ])\S*$/' @change="handleInputChange"></rp-input>
                <!-- 点击眼睛图标切换showPwd变量 -->
                <i class="eye-icon" @click="toggleShowPwd"></i>
            <label class="label">
                <a href="#" class="label-text-alt link link-hover">忘记密码?</a>
            </label>
            </div>
            <div class="form-control mt-6">
            <button class="btn btn-primary" @click="Login()">登录</button>
            </div>
        </div>
    </div>
    </div>
</div>
</template>
<script setup lang='ts'>
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
import { login } from '@/api/login'
import rpInput from '@/components/basic/rp-input.vue';
// 导入vue

// 定义响应式变量
const showPwd = ref(false) // 控制密码显示与隐藏
const errorValue = ref(false)

// 定义方法
const toggleShowPwd = () => {
    showPwd.value = !showPwd.value
}

// 使用useRouter获取router对象
const router = useRouter()

// 定义登录方法
const loginForm = reactive({
    username: '',
    password: ''
})
const Login = async () => {
    if (errorValue.value) {
        const data = await login(loginForm)
        console.log(data);
    }
}

function handleInputChange(error: boolean) {
    errorValue.value = error
} 
</script>
<style lang="less">
.login {
    background-image: url('@/assets/images/background.jpg');
}
</style>