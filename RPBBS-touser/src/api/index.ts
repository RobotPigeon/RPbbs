import { login } from '@/api/login';
import router from '@/router';
import axios, { AxiosError, type AxiosInstance, type AxiosRequestConfig, type AxiosResponse, type InternalAxiosRequestConfig } from 'axios'
import { inject } from "vue";
import useuserStore from '@/stores/user';
import useAlertStore from '@/stores/alert';
const showAlert = inject("showAlert") as Function;
// 数据返回的接口
// 定义请求响应参数，不含data
interface Result {
    code: number;
    msg: string
}

// 请求响应参数，包含data
interface ResultData<T = any> extends Result {
    img: string;
    uuid: string;
    captchaEnabled: undefined;
    token: string;
    data?: T;
}
const URL: string | undefined = import.meta.env.VITE_API
enum RequestEnums {
    TIMEOUT = 20000,
    OVERDUE = 600, // 登录失效
    FAIL = 999, // 请求失败
    SUCCESS = 200, // 请求成功
}
const config = {
    // 默认地址
    baseURL: URL as string,
    // 设置超时时间
    timeout: RequestEnums.TIMEOUT as number,
    // 跨域时候允许携带凭证
    withCredentials: true,
}

class RequestHttp {
    // 定义成员变量并指定类型
    service: AxiosInstance;
    public constructor(config: AxiosRequestConfig) {
        // 实例化axios
        this.service = axios.create(config);

        /**
         * 请求拦截器
         * 客户端发送请求 -> [请求拦截器] -> 服务器
         * token校验(JWT) : 接受服务器返回的token,存储到vuex/pinia/本地储存当中
         */
        this.service.interceptors.request.use(
            (config: InternalAxiosRequestConfig) => {
                //pinia获取token
                // const token = useUserStore().token;
                //getters使用
                const userStore = useuserStore()
                const token = localStorage.getItem('token') || '' || userStore.getToken;
                if (token) {
                    config.headers.set('Authorization', token)
                    console.log(config);
                }

                return config
            },
            (error: AxiosError) => {
                useAlertStore().setAlert({ message: "请求报错", type: "error" });
                Promise.reject(error)
            }
        )

        /**
         * 响应拦截器
         * 服务器换返回信息 -> [拦截统一处理] -> 客户端JS获取到信息
         */
        this.service.interceptors.response.use(
            (response: AxiosResponse) => {
                const { data, config } = response; // 解构
                if (data.code === RequestEnums.OVERDUE) {
                    // 登录信息失效，应跳转到登录页面，并清空本地的token和id
                    localStorage.setItem('token', '');
                    localStorage.setItem('id','');
                    //跳转登录页面
                    router.push('/login');
                    return Promise.reject(data);
                }
                // 全局错误信息拦截（防止下载文件得时候返回数据流，没有code，直接报错）
                if (data.code && data.code !== RequestEnums.SUCCESS) {
                    useAlertStore().setAlert({ message: data.msg, type: "error" });
                    return Promise.reject(data)
                }
                return data;
            },
            (error: AxiosError) => {
                const { response } = error;
                if (response) {
                    this.handleCode(response.status)
                }
                if (!window.navigator.onLine) {
                    useAlertStore().setAlert({ message: "网络连接失败", type: "error" });
                    // 可以跳转到错误页面，也可以不做操作
                    // return router.replace({
                    //   path: '/error'
                    // });
                }
            }
        )
    }
    handleCode(code: number): void {
        switch (code) {
            case 401:
                useAlertStore().setAlert({ message: "登录失败，请重新登录", type: "error" });
                break;
            default:
                useAlertStore().setAlert({ message: "请求失败", type: "error" });
                break;
        }
    }

    // 常用方法封装
    get<T>(url: string, params?: object): Promise<ResultData<T>> {
        return this.service.get(url, { params });
    }
    post<T>(url: string, params?: object): Promise<ResultData<T>> {
        return this.service.post(url, params);
    }
    put<T>(url: string, params?: object): Promise<ResultData<T>> {
        return this.service.put(url, params);
    }
    delete<T>(url: string, params?: object): Promise<ResultData<T>> {
        return this.service.delete(url, { params });
    }
}

// 导出一个实例对象
export default new RequestHttp(config);

function useUserStore() {
    throw new Error('Function not implemented.');
}
