import request from '@/utils/request'

export function getPostHotList (params) {
  return request({
    url: '/post/app/postHots',
    method: 'get',
    params: params
  })
}

export function getPostActivityHotList (params) {
  return request({
    url: '/post/app/hot/postActivities',
    method: 'get',
    params: params
  })
}

export function getPostContentHotList (params) {
  return request({
    url: '/post/app/hot/postContents',
    method: 'get',
    params: params
  })
}
