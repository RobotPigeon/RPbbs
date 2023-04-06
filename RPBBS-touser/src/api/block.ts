import axios from './'
//获取板块信息
export function getBlocklist() {
    return axios.get<any>('/block/list')
}
