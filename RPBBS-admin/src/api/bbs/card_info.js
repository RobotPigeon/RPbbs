import request from '@/utils/request'

// 查询帖子信息列表
export function listCard_info(query) {
  return request({
    url: '/bbs/card_info/list',
    method: 'get',
    params: query
  })
}

// 查询帖子信息详细
export function getCard_info(id) {
  return request({
    url: '/bbs/card_info/' + id,
    method: 'get'
  })
}

// 新增帖子信息
export function addCard_info(data) {
  return request({
    url: '/bbs/card_info',
    method: 'post',
    data: data
  })
}

// 修改帖子信息
export function updateCard_info(data) {
  return request({
    url: '/bbs/card_info',
    method: 'put',
    data: data
  })
}

// 删除帖子信息
export function delCard_info(id) {
  return request({
    url: '/bbs/card_info/' + id,
    method: 'delete'
  })
}
