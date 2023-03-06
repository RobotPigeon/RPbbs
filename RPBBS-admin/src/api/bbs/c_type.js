import request from '@/utils/request'

// 查询帖子类型列表
export function listC_type(query) {
  return request({
    url: '/bbs/c_type/list',
    method: 'get',
    params: query
  })
}

// 查询帖子类型详细
export function getC_type(id) {
  return request({
    url: '/bbs/c_type/' + id,
    method: 'get'
  })
}

// 新增帖子类型
export function addC_type(data) {
  return request({
    url: '/bbs/c_type',
    method: 'post',
    data: data
  })
}

// 修改帖子类型
export function updateC_type(data) {
  return request({
    url: '/bbs/c_type',
    method: 'put',
    data: data
  })
}

// 删除帖子类型
export function delC_type(id) {
  return request({
    url: '/bbs/c_type/' + id,
    method: 'delete'
  })
}
