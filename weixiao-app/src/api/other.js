import request from '@/utils/request'

export function checkSignActivity (params) {
  return request({
    url: '/post/postSign/check',
    method: 'get',
    params: params
  })
}
