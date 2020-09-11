import request from '@/utils/request'

export function getPostInfo (params) {
  return request({
    url: '/student/studentMember/postinfo',
    method: 'get',
    params: params
  })
}

export function checkFollow (params) {
  return request({
    url: '/student/studentFollow/check',
    method: 'get',
    params: params
  })
}

export function postFollow (params) {
  return request({
    url: '/student/studentFollow',
    method: 'post',
    data: params
  })
}

export function cancelFollow (params) {
  return request({
    url: '/student/studentFollow/cancel',
    method: 'delete',
    params: params
  })
}
