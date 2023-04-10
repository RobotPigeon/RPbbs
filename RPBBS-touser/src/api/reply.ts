import axios from './'
//发布一级评论
export function postReply(data: any) {
    return axios.post<any>('/card_center/reply', data)
}
//发布二级评论
export function postReplyReply(data: any) {
    return axios.post<any>('/card_center/reply/reply', data)
}

//获取评论
export function getReply(current: any = 1, size: number = 10, id: any) {
    return axios.get<any>('/card_center/reply/page/?' + `current=${current}&size=${size}&cardId=${id}`)
}