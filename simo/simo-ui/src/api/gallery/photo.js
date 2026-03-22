import request from '@/utils/request'

// 查询图片核心信息列表
export function listPhoto(query) {
  return request({
    url: '/gallery/photo/list',
    method: 'get',
    params: query
  })
}

// 查询图片核心信息详细
export function getPhoto(photoId) {
  return request({
    url: '/gallery/photo/' + photoId,
    method: 'get'
  })
}

// 新增图片核心信息
export function addPhoto(data) {
  return request({
    url: '/gallery/photo',
    method: 'post',
    data: data
  })
}

// 修改图片核心信息
export function updatePhoto(data) {
  return request({
    url: '/gallery/photo',
    method: 'put',
    data: data
  })
}

// 删除图片核心信息
export function delPhoto(photoId) {
  return request({
    url: '/gallery/photo/' + photoId,
    method: 'delete'
  })
}
