import request from '@/utils/request'

export function getActivityListPage(params) {
  return request({
    url: '/post/postActivities',
    method: 'get',
    params: params
  })
}
export function reviewActivity(params) {
  return request({
    url: '/post/postActivity/review',
    method: 'put',
    params: params
  })
}
export function batchPassActivity(params) {
  return request({
    url: '/post/postActivity/batchpass',
    method: 'put',
    params: params
  })
}
export function getCatgoryList(params) {
  return request({
    url: '/post/postCategories',
    method: 'get',
    params: params
  })
}
export function getSignList(params) {
  return request({
    url: '/post/postSigns',
    method: 'get',
    params: params
  })
}
