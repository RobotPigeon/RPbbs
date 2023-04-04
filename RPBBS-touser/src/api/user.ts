import axios from './'
//获取用户信息
export function getUserInfo(id: string) {
    return axios.get('/user_info/' + id)
}