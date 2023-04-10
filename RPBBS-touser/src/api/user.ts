import axios from './'
//获取用户信息
export function getUserInfo(id: any) {
    return axios.get<any>('/user_info/userId/' + id)
}
