import axios from './'
namespace register {
    // 用户登录表单
    export interface registerForm {
        username: string;
        password: string;
    }
    export interface LoginCode {
        uuid: string;
        image: string;
    }
    // 登录成功后返回的token
    export interface registerData {
    }
}
// 用户注册
export const register = (params: register.registerForm) => {
    // 返回的数据格式可以和服务端约定
    return axios.post<register.registerData>('/register/register', params);
}