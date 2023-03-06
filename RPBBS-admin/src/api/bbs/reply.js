import request from '@/utils/request'

// 查询回复帖子列表
export function listReply(query) {
  return request({
    url: '/bbs/reply/list',
    method: 'get',
    params: query
  })
}

// 查询回复帖子详细
export function getReply(id) {
  return request({
    url: '/bbs/reply/' + id,
    method: 'get'
  })
}

// 新增回复帖子
export function addReply(data) {
  return request({
    url: '/bbs/reply',
    method: 'post',
    data: data
  })
}

// 修改回复帖子
export function updateReply(data) {
  return request({
    url: '/bbs/reply',
    method: 'put',
    data: data
  })
}

// 删除回复帖子
export function delReply(id) {
  return request({
    url: '/bbs/reply/' + id,
    method: 'delete'
  })
}
