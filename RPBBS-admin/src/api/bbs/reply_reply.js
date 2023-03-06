import request from '@/utils/request'

// 查询二级回复帖子列表
export function listReply_reply(query) {
  return request({
    url: '/bbs/reply_reply/list',
    method: 'get',
    params: query
  })
}

// 查询二级回复帖子详细
export function getReply_reply(id) {
  return request({
    url: '/bbs/reply_reply/' + id,
    method: 'get'
  })
}

// 新增二级回复帖子
export function addReply_reply(data) {
  return request({
    url: '/bbs/reply_reply',
    method: 'post',
    data: data
  })
}

// 修改二级回复帖子
export function updateReply_reply(data) {
  return request({
    url: '/bbs/reply_reply',
    method: 'put',
    data: data
  })
}

// 删除二级回复帖子
export function delReply_reply(id) {
  return request({
    url: '/bbs/reply_reply/' + id,
    method: 'delete'
  })
}
