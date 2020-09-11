import request from '@/utils/request'

export function getMyFollow (params) {
  return request({
    url: '/student/studentMember/myfollow',
    method: 'get',
    params: params
  })
}

export function cancelFollow (params) {
  return request({
    url: '/student/studentFollow/cancel',
    method: 'delete',
    params: params
  })
}
