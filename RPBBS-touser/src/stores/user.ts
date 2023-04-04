import { defineStore } from 'pinia'
import { login } from '@/api/login'
import router from '@/router';

export default defineStore('user', {
    state: () => ({
        token: '' as any,
        id: '' as any,
    }),
    actions: {
        loadToken() {
            const token = localStorage.getItem('token') || ''
            this.token = token
        },
        loadUser() {
            const id = localStorage.getItem('id') || ''
            console.log(localStorage.getItem('id'));

            this.id = id
        },
        Login(loginForm: Array<{ username: string, password: string, code: string, uuid: string }>[0]) {
            return new Promise((resolve, reject) => {
                login(loginForm).then(res => {
                    this.token = res.data?.token
                    this.id = res.data?.user.id
                    localStorage.setItem('id', this.id)
                    localStorage.setItem('token', this.token)
                    console.log(this.token);
                    // 跳转到首页
                    router.push("/");
                }).catch(error => {
                    reject(error)
                });
            })
        }
    },
    getters: {
        getToken(): string | null {
            // 在返回token之前调用loadToken action
            this.loadToken()
            return this.token
        },
        getUser(): any {
            this.loadUser()
            return this.id
        }
    }
})