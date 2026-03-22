import request from '@/utils/request'

// 查询相册图片关联列表
export function listAlbumPhoto(query) {
  return request({
    url: '/gallery/albumPhoto/list',
    method: 'get',
    params: query
  })
}

// 查询相册图片关联详细
export function getAlbumPhoto(albumId) {
  return request({
    url: '/gallery/albumPhoto/' + albumId,
    method: 'get'
  })
}

// 新增相册图片关联
export function addAlbumPhoto(data) {
  return request({
    url: '/gallery/albumPhoto',
    method: 'post',
    data: data
  })
}

// 修改相册图片关联
export function updateAlbumPhoto(data) {
  return request({
    url: '/gallery/albumPhoto',
    method: 'put',
    data: data
  })
}

// 删除相册图片关联
export function delAlbumPhoto(albumId) {
  return request({
    url: '/gallery/albumPhoto/' + albumId,
    method: 'delete'
  })
}
