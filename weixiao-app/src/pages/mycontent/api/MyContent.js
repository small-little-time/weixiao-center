import request from '@/utils/request'

export function getMyContent (params) {
  return request({
    url: '/student/studentMember/content',
    method: 'get',
    params: params
  })
}

export function deleteMyContent (params) {
  return request({
    url: '/post/postContent/' + params.id,
    method: 'delete'
  })
}
