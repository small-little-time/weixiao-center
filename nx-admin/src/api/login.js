import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/adm/login',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/adm/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/adm/logout',
    method: 'post'
  })
}
