import request from '@/utils/request'

export function getHotspotListPage(params) {
  return request({
    url: '/post/postHots',
    method: 'get',
    params: params
  })
}
export function removeHotspot(params) {
  return request({
    url: '/post/postHot/' + params.id,
    method: 'delete',
    params: params
  })
}
export function batchRemoveHotspot(params) {
  return request({
    url: '/post/postHot/batchdelete',
    method: 'delete',
    params: params
  })
}
export function editHotspot(params) {
  return request({
    url: '/post/postHot',
    method: 'put',
    data: params
  })
}
export function addHotspot(params) {
  return request({
    url: '/post/postHot',
    method: 'post',
    data: params
  })
}
