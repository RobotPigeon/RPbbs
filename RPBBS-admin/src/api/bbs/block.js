import request from '@/utils/request'

// 查询帖子板块列表
export function listBlock(query) {
  return request({
    url: '/bbs/block/list',
    method: 'get',
    params: query
  })
}

// 查询帖子板块详细
export function getBlock(id) {
  return request({
    url: '/bbs/block/' + id,
    method: 'get'
  })
}

// 新增帖子板块
export function addBlock(data) {
  return request({
    url: '/bbs/block',
    method: 'post',
    data: data
  })
}

// 修改帖子板块
export function updateBlock(data) {
  return request({
    url: '/bbs/block',
    method: 'put',
    data: data
  })
}

// 删除帖子板块
export function delBlock(id) {
  return request({
    url: '/bbs/block/' + id,
    method: 'delete'
  })
}
