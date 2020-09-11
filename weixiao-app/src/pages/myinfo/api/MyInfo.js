import request from '@/utils/request'

export function updateInfo (params) {
  return request({
    url: '/student/updateinfo',
    method: 'put',
    data: params
  })
}
