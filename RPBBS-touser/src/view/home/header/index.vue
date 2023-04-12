<template>
    <div class="navbar bg-base-100">
        <div class="dropdown navbar-start">
            <label tabindex="0" class="btn  btn-ghost  avatar">
                <span class="lowercase text-primary background-color-yellow ">GAME</span>
                <span class="uppercase text-base-content">AREA</span>
            </label>
            <ul tabindex="0" class="menu menu-compact dropdown-content mt-3 p-2 shadow rounded-box w-52 bg-base-100">
                <li>
                    <a class="justify-between" href="/home">
                        主页
                    </a>
                </li>
                <li><a href="/home/Partition">热门版面</a></li>
            </ul>
        </div>
        <div class="">
            <div class="flex justify-center text-3xl w-full">
                ⭐
            </div>

        </div>
        <div class="navbar-end">
            <div class="dropdown dropdown-end">
                <label tabindex="0" class="btn  btn-ghost  avatar">
                    <div class="w-12 rounded-box">
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