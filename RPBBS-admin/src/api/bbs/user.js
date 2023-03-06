import request from '@/utils/request'

// 查询用户列表
export function listUser(query) {
  return request({
    url: '/bbs/user/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getUser(id) {
  return request({
    url: '/bbs/user/' + id,
    method: 'get'
  })
}

// 新增用户
export function addUser(data) {
  return request({
    url: '/bbs/user',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateUser(data) {
  return request({
    url: '/bbs/user',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delUser(id) {
  return request({
    url: '/bbs/user/' + id,
    method: 'delete'
  })
}
