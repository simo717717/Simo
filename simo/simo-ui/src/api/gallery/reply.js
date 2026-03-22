import request from '@/utils/request'

// 查询论坛回复管理列表
export function listReply(query) {
  return request({
    url: '/gallery/reply/list',
    method: 'get',
    params: query
  })
}

// 查询论坛回复管理详细
export function getReply(replyId) {
  return request({
    url: '/gallery/reply/' + replyId,
    method: 'get'
  })
}

// 新增论坛回复管理
export function addReply(data) {
  return request({
    url: '/gallery/reply',
    method: 'post',
    data: data
  })
}

// 修改论坛回复管理
export function updateReply(data) {
  return request({
    url: '/gallery/reply',
    method: 'put',
    data: data
  })
}

// 删除论坛回复管理
export function delReply(replyId) {
  return request({
    url: '/gallery/reply/' + replyId,
    method: 'delete'
  })
}
