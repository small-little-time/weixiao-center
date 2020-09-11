import request from '@/utils/request'

export function getContentListPage(params) {
  return request({
    url: '/post/postContents',
    method: 'get',
    params: params
  })
}
export function batchPassContent(params) {
  return request({
    url: '/post/postContent/batchreview',
    method: 'put',
    params: params
  })
}
export function enableOrDisable(params) {
  return request({
    url: '/postContent/enableordisable',
    method: 'put',
    params: params
  })
}
export function review(params) {
  return request({
    url: '/post/postContent/review',
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
