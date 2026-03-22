import request from '@/utils/request'

// 查询论坛帖子管理列表
export function listPost(query) {
  return request({
    url: '/gallery/post/list',
    method: 'get',
    params: query
  })
}

// 查询论坛帖子管理详细
export function getPost(postId) {
  return request({
    url: '/gallery/post/' + postId,
    method: 'get'
  })
}

// 新增论坛帖子管理
export function addPost(data) {
  return request({
    url: '/gallery/post',
    method: 'post',
    data: data
  })
}

// 修改论坛帖子管理
export function updatePost(data) {
  return request({
    url: '/gallery/post',
    method: 'put',
    data: data
  })
}

// 删除论坛帖子管理
export function delPost(postId) {
  return request({
    url: '/gallery/post/' + postId,
    method: 'delete'
  })
}
