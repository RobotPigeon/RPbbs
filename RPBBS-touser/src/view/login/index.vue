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
            <rp-input type="text" errorValue='请输入正确的用户名' v-model="loginForm.username" :required="true"></rp-input>
            </div>
            <div class="form-control">
            <label class="label">
                <span class="label-text">密码</span>
            </label>
                <!-- 如果showPwd为true，则显示type为text的输入框 -->
                <rp-input v-if="showPwd" type="text" errorValue='请输入正确的密码' v-model="loginForm.password" :required="true" :pattern='/^\S*(?=\S{6,})(?=\S*\d)(?=\S*[A-Z])(?=\S*[a-z])(?=\S*[!@#$%^&*? ])\S*$/' @change="handleInputChange"></rp-input>
                <!-- 如果showPwd为false，则显示type为password的输入框 -->
                <rp-input v-else type="password" errorValue='请输入正确的密码' v-model="loginForm.password" :required="true" :pattern='/^\S*(?=\S{6,})(?=\S*\d)(?=\S*[A-Z])(?=\S*[a-z])(?=\S*[!@#$%^&*? ])\S*$/' @change="handleInputChange"></rp-input>
                <!-- 点击眼睛图标切换showPwd变量 -->
                <i class="eye-icon" @click="toggleShowPwd"></i>
            <label class="label">
                <span>
                验证码
                </span>
            </label>
            <rp-input type="text" errorValue='请输入验证码' v-model="loginForm.code" :required="true"></rp-input>
            <div class="login-code">
            <img :src="codeUrl" @click="getCode" class="login-code-img"/>
            </div>
            <label class="label">
                <a href="#" class="label-text-alt link link-hover">忘记密码?</a>
            </label>
            </div>
            <div class="form-control mt-6">
            <button v-if="!loading" class="btn btn-primary" @click="Login()">登录</button>
            <button v-else class="btn" @click="Login()">登录中...</button>
            </div>
        </div>
    </div>
    </div>
</div>
</template>
<script setup lang='ts'>
import { ref, reactive, inject } from 'vue'
import { useRouter } from 'vue-router'
import { getCodeImg } from '@/api/login'
import rpInput from '@/components/basic/rp-input.vue';
//全局alert组件的使用
import useAlertStore from '@/stores/alert';
import useUserStore from '@/stores/user';



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
    password: '',
    code: '',
    uuid: '',
})

// 验证码开关
const codeUrl = ref("");
const captchaEnabled = ref(true);
function getCode() {
    getCodeImg().then(res => {
        captchaEnabled.value = res.captchaEnabled === undefined ? true : res.captchaEnabled;
        if (captchaEnabled.value) {
            codeUrl.value = "data:image/gif;base64," + res.img;
            loginForm.uuid = res.uuid;
        }
    });
}

// 注入showAlert方法
const showAlert = inject("showAlert") as Function;

const loading = ref(false);
const Login = async () => {
    if (errorValue.value) {
        loading.value = true;
        console.log(loginForm);
        useUserStore().Login(loginForm).then(() => {
            // router.push({ path: "/" });
            useAlertStore().setAlert({ message: "登录成功", type: "succee" });
        }).catch(() => {
            loading.value = false;
            // 重新获取验证码
            if (captchaEnabled.value) {
                getCode();
            }
        });
    } else {
        //使用showAlert方法
        const showAlert = inject("showAlert") as Function;
        useAlertStore().setAlert({ message: "请检查账号密码", type: "error" });
    }
}

function handleInputChange(error: boolean) {
    errorValue.value = error
}
getCode()
</script>
<style lang="less">
.login {
    background-image: url('@/assets/images/background.jpg');
}
</style>