// user.ts
import { defineStore } from 'pinia'
import jwtDecode from 'jwt-decode'
import { login } from '@/api/login'
// import { getToken, setToken, removeToken } from '@/utils/auth'


// 定义用户信息的接口
interface User {
    username: string
    role: string
    avatar: string
    email: string
}

export default defineStore('user', {
    state: () => ({
        token: '',
        user: null as User | null // 使用类型断言
    }),
    actions: {
        // 从本地存储中读取并解析token
        loadToken() {
            const token = localStorage.getItem('token') || ''
            this.token = token
            if (token) {
                this.user = jwtDecode(token) as User // 使用类型断言
            }
        },
        Login(loginForm: Array<{ username: string, password: string, code: string, uuid: string }>[0]) {
            const username = loginForm.username.trim()
            const password = loginForm.password
            const code = loginForm.code
            const uuid = loginForm.uuid
            return new Promise((resolve, reject) => {
                login(loginForm).then(res => {
                    this.token = res.token
                    localStorage.setItem('token', this.token)
                }).catch(error => {
                    reject(error)
                });
            })
        }
    },
    getters: {
        // 返回token和用户信息
        getToken(): string {
            return this.token
        },
        getUser(): User | null {
            return this.user
        }
    }
})