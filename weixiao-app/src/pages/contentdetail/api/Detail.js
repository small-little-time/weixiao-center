import request from '@/utils/request'

export function getDetail (params) {
  return request({
    url: '/post/postContent/' + params.id,
    method: 'get',
    params: {
      'studentid': params.studentId
    }
  })
}

export function postCollect (params) {
  return request({
    url: '/post/postCollect',
    method: 'post',
    data: params
  })
}

export function putCollect (params) {
  return request({
    url: '/post/postCollect',
    method: 'put',
    data: params
  })
}

export function postLike (params) {
  return request({
    url: '/post/postLike',
    method: 'post',
    data: params
  })
}

export function putLike (params) {
  return request({
    url: '/post/postLike',
    method: 'put',
    data: params
  })
}
