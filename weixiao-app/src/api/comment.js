import request from '@/utils/request'

export function getComment (params) {
  return request({
    url: '/post/app/postComments',
    method: 'get',
    params: params
  })
}

export function postComment (params) {
  return request({
    url: '/post/postComment',
    method: 'post',
    data: params
  })
}
