import request from '@/utils/request'

export function getMyCollect (params) {
  return request({
    url: '/student/studentMember/collect',
    method: 'get',
    params: params
  })
}
