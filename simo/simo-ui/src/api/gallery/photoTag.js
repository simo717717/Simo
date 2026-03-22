import request from '@/utils/request'

// 查询图片标签关联列表
export function listPhotoTag(query) {
  return request({
    url: '/gallery/photoTag/list',
    method: 'get',
    params: query
  })
}

// 查询图片标签关联详细
export function getPhotoTag(photoId) {
  return request({
    url: '/gallery/photoTag/' + photoId,
    method: 'get'
  })
}

// 新增图片标签关联
export function addPhotoTag(data) {
  return request({
    url: '/gallery/photoTag',
    method: 'post',
    data: data
  })
}

// 修改图片标签关联
export function updatePhotoTag(data) {
  return request({
    url: '/gallery/photoTag',
    method: 'put',
    data: data
  })
}

// 删除图片标签关联
export function delPhotoTag(photoId) {
  return request({
    url: '/gallery/photoTag/' + photoId,
    method: 'delete'
  })
}
