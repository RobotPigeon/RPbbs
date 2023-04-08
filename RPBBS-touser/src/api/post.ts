import axios from './'
//发布贴文

export function postArticle(data: any) {
    return axios.post<any>('/article', data)
}
