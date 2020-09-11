import request from '@/utils/request'

export function getSignList (params) {
  return request({
    url: '/post/postSign/list',
    method: 'get',
    params: params
  })
}
