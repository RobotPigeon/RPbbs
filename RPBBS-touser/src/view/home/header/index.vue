<template>
    <div class="navbar bg-base-100">
        <div class="navbar-start">
            <a class="btn btn-ghost normal-case text-xl" href="/">RPBBS</a>
            <!-- 图标 -->
            <div class="flex justify-center my-10">
                <label class="swap swap-rotate">

                    <!-- this hidden checkbox controls the state -->
                    <input type="checkbox" data-toggle-theme="dark,light" data-act-class="ACTIVECLASS" />

                    <!-- sun icon -->
                    <svg class="swap-on fill-current w-10 h-10" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                        <path
                            d="M5.64,17l-.71.71a1,1,0,0,0,0,1.41,1,1,0,0,0,1.41,0l.71-.71A1,1,0,0,0,5.64,17ZM5,12a1,1,0,0,0-1-1H3a1,1,0,0,0,0,2H4A1,1,0,0,0,5,12Zm7-7a1,1,0,0,0,1-1V3a1,1,0,0,0-2,0V4A1,1,0,0,0,12,5ZM5.64,7.05a1,1,0,0,0,.7.29,1,1,0,0,0,.71-.29,1,1,0,0,0,0-1.41l-.71-.71A1,1,0,0,0,4.93,6.34Zm12,.29a1,1,0,0,0,.7-.29l.71-.71a1,1,0,1,0-1.41-1.41L17,5.64a1,1,0,0,0,0,1.41A1,1,0,0,0,17.66,7.34ZM21,11H20a1,1,0,0,0,0,2h1a1,1,0,0,0,0-2Zm-9,8a1,1,0,0,0-1,1v1a1,1,0,0,0,2,0V20A1,1,0,0,0,12,19ZM18.36,17A1,1,0,0,0,17,18.36l.71.71a1,1,0,0,0,1.41,0,1,1,0,0,0,0-1.41ZM12,6.5A5.5,5.5,0,1,0,17.5,12,5.51,5.51,0,0,0,12,6.5Zm0,9A3.5,3.5,0,1,1,15.5,12,3.5,3.5,0,0,1,12,15.5Z" />
                    </svg>

                    <!-- moon icon -->
                    <svg class="swap-off fill-current w-10 h-10" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                        <path
                            d="M21.64,13a1,1,0,0,0-1.05-.14,8.05,8.05,0,0,1-3.37.73A8.15,8.15,0,0,1,9.08,5.49a8.59,8.59,0,0,1,.25-2A1,1,0,0,0,8,2.36,10.14,10.14,0,1,0,22,14.05,1,1,0,0,0,21.64,13Zm-9.5,6.69A8.14,8.14,0,0,1,7.08,5.22v.27A10.15,10.15,0,0,0,17.22,15.63a9.79,9.79,0,0,0,2.1-.22A8.11,8.11,0,0,1,12.14,19.73Z" />
                    </svg>
                </label>
            </div>
            <!-- 夜间模式切换器 -->
        </div>
        <div class="navbar-center">

        </div>
        <div class="navbar-end">
            <!-- <div class="form-control">
                <input type="text" placeholder="Search" class="input input-bordered hidden-search" />
            </div> -->
            <!-- 搜索栏 -->
            <!-- <button class="btn btn-ghost btn-circle hidden-search">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" fill="none" viewBox="0 0 24 24"
                    stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
                </svg>
            </button> -->
            <!-- 搜索按钮 -->
            <!-- <button class="btn btn-ghost btn-circle">
                <div class="indicator">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9" />
                    </svg>
                    <span class="badge badge-xs badge-primary indicator-item"></span>
                </div>
            </button> -->
            <!-- 通知按钮 -->
            <div class="dropdown dropdown-end">
                <label tabindex="0" class="btn btn-ghost btn-circle avatar">
                    <div class="w-10 rounded-full">
                        <img :src="avatar" />
                    </div>
                </label>
                <ul tabindex="0" v-if="useuserStore().getUser == ''"
                    class="menu menu-compact dropdown-content mt-3 p-2 shadow rounded-box w-52 bg-base-100">
                    <li>
                        <a class="justify-between" href="/login">
                            登录/注册账号
                            <!-- <span class="badge">New</span> -->
                        </a>
                    </li>
                </ul>
                <ul tabindex="0" v-else
                    class="menu menu-compact dropdown-content mt-3 p-2 shadow rounded-box w-52 bg-base-100">
                    <li>
                        <a class="justify-between" href="/home/posteditor">
                            帖子发布
                            <!-- <span class="badge">New</span> -->
                        </a>
                    </li>
                    <li><a @click="log()">退出登录</a></li>
                </ul>
            </div>
            <!-- 用户头像下拉框 -->
        </div>
    </div>
</template>
    
<script setup lang='ts'>
import { ref, reactive, onMounted } from 'vue';
import useuserStore from '@/stores/user'
import { getUserInfo } from '@/api/user';
const handleChangeTheme = () => {
    const html = document.getElementsByTagName('html')[0]
    const darkTheme = html.dataset.theme

    if (darkTheme === 'dark') {
        html.dataset.theme = 'light'
    } else {
        html.dataset.theme = 'dark'
    }
}
//用户信息变数
const user = reactive({
    id: '',
    name: '',
    avatar: '',
})

//navabar组件挂载时执行
onMounted(() => {
    //获取用户信息
    let id = useuserStore().getUser
    //如果id不为空则获取用户信息
    if (id) {
        getUserInfo(id).then(res => {
            avatar.value = res.data[0].avatarPath
        })
    }
})
//打印hello world
function log() {
    let i = useuserStore().getUser
    console.log(i);
}
//  头像地址
const avatar = ref('')

</script>
    
<style scoped lang='less'>
@media (max-width: 720px) {

    .hidden-search {

        display: none;

    }

}
</style>