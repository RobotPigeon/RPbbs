import axios from './'
//发布贴文

export function postArticle(data: any) {
    return axios.post<any>('/article', data)
}
//帖子文件上传
export function postArticleFile(data: any) {
    return axios.post<any>('/file/upload', data)
}