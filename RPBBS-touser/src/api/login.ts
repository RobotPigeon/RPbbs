import axios from './'
namespace Login {
    // 用户登录表单
    export interface LoginReqForm {
        username: string;
        password: string;
        code: string;
        uuid: string;
    }
    export interface LoginCode {
        uuid: string;
        image: string;
    }
    // 登录成功后返回的token
    export interface LoginResData {
        token: string;
    }
}
// 用户登录
export const login = (params: Login.LoginReqForm) => {
    // 返回的数据格式可以和服务端约定
    return axios.post<Login.LoginResData>('/login/check', params);
}
// 获取验证码
export function getCodeImg() {
    return axios.get<Login.LoginCode>('/login/kaptcha/get')
}