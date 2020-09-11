import request from '@/utils/request'

export function upload (params) {
  return request({
    url: '/file/upload',
    method: 'post',
    data: params
  })
}

export function postContent (params) {
  return request({
    url: '/post/postContent',
    method: 'post',
    data: params
  })
}
