import request from '@/utils/request'

export function getMyPublish (params) {
  return request({
    url: '/student/studentMember/activity',
    method: 'get',
    params: params
  })
}

export function cancelMyPublish (params) {
  return request({
    url: '/post/postActivity/cancel/' + params.id,
    method: 'put'
  })
}

export function getMyParticipation (params) {
  return request({
    url: '/student/studentMember/participation',
    method: 'get',
    params: params
  })
}

export function cancelMyParticipation (params) {
  return request({
    url: '/post/postSign/cancel',
    method: 'put',
    params: params
  })
}
