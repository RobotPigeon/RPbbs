import type { LocationQueryValue } from 'vue-router'
import axios from './'
//获取板块列表
export function getBlocklist() {
    return axios.get<any>('/block/page?page='+1+'&size='+100)
}
//获取板块详情
export function getBlockDetail(id: string | LocationQueryValue[]) {
    return axios.get<any>('/block/' + id)
}
