import request from '@/utils/request'

export function getContent (params) {
  return request({
    url: '/post/app/postContents',
    method: 'get',
    params: params
  })
}

export function getChatOff (params) {
  return request({
    url: 'http://localhost:6003/message/messageContents',
    method: 'get',
    params: params
  })
}

export function batchSign (params) {
  return request({
    url: 'http://localhost:6003/message/batchsign',
    method: 'put',
    params: params
  })
}
