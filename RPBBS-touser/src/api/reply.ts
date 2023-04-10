import axios from './'
//发布一级评论
export function postReply(data: any) {
    return axios.post<any>('/card_center/reply', data)
}
//发布二级评论
export function postReplyReply(data: any) {
    return axios.post<any>('/card_center/reply/reply', data)
}