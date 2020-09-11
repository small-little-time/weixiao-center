import request from '@/utils/request'

export function upload (params) {
  return request({
    url: '/file/upload',
    method: 'post',
    data: params
  })
}

export function postActivity (params) {
  return request({
    url: '/post/postActivity',
    method: 'post',
    data: params
  })
}
