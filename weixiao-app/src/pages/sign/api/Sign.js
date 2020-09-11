import request from '@/utils/request'

export function postSign (params) {
  return request({
    url: '/post/postSign',
    method: 'post',
    data: params
  })
}
