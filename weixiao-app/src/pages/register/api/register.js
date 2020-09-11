import request from '@/utils/request'

export function canRegister (username) {
  return request({
    url: '/student/canregister',
    method: 'post',
    params: { username }
  })
}

export function register (params) {
  return request({
    url: '/student/register',
    method: 'post',
    params: {
      username: params.username,
      password: params.password
    }
  })
}

export function updateInfo (params, authorization) {
  return request({
    url: '/student/studentMember',
    method: 'put',
    headers: {
      'authorization': authorization
    },
    data: params
  })
}
