import request from '@/utils/request'

// 查询图片EXIF参数列表
export function listExif(query) {
  return request({
    url: '/gallery/exif/list',
    method: 'get',
    params: query
  })
}

// 查询图片EXIF参数详细
export function getExif(photoId) {
  return request({
    url: '/gallery/exif/' + photoId,
    method: 'get'
  })
}

// 新增图片EXIF参数
export function addExif(data) {
  return request({
    url: '/gallery/exif',
    method: 'post',
    data: data
  })
}

// 修改图片EXIF参数
export function updateExif(data) {
  return request({
    url: '/gallery/exif',
    method: 'put',
    data: data
  })
}

// 删除图片EXIF参数
export function delExif(photoId) {
  return request({
    url: '/gallery/exif/' + photoId,
    method: 'delete'
  })
}
