import request from '@/utils/request'

// 查询用户信息列表
export function listUser_info(query) {
  return request({
    url: '/bbs/user_info/list',
    method: 'get',
    params: query
  })
}

// 查询用户信息详细
export function getUser_info(id) {
  return request({
    url: '/bbs/user_info/' + id,
    method: 'get'
  })
}

// 新增用户信息
export function addUser_info(data) {
  return request({
    url: '/bbs/user_info',
    method: 'post',
    data: data
  })
}

// 修改用户信息
export function updateUser_info(data) {
  return request({
    url: '/bbs/user_info',
    method: 'put',
    data: data
  })
}

// 删除用户信息
export function delUser_info(id) {
  return request({
    url: '/bbs/user_info/' + id,
    method: 'delete'
  })
}
