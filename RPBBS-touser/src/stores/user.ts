// user.ts
import { defineStore } from 'pinia'
import jwtDecode from 'jwt-decode'


// 定义用户信息的接口
interface User {
    name: string
    role: string
    email: string
}

export const useUserStore = defineStore('user', {
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
        }
    },
    getters: {
        // 返回token和用户信息
        getToken(): string {
            return this.token
        },
        getUser():User | null {
            return this.user
        }
    }
})