import axios from './'
//发布贴文

export function postArticle(data: any) {
    return axios.post<any>('/bbs/card_center/submit', data)
}
//帖子文件上传
export function postArticleFile(data: FormData) {
    return axios.post<any>('/bbs/file/upload', data)
}

//帖子获取/card_center/page，分页current默认为0，size默认为10，blockId默认为0
export function getArticle(current: any= 0, size: number = 10, blockId: any = 0) {
    return axios.get<any>('/bbs/card_center/page?' + `current=${current}&size=${size}&blockId=${blockId}`)
}

//获取帖子信息详情
export function getArticleDetail(id: any) {
    return axios.get<any>('/bbs/card_info/' + id)
}
//获取帖子基本信息
export function getArticleBaseInfo(id: any) {
    return axios.get<any>('/bbs/card/' + id)
}