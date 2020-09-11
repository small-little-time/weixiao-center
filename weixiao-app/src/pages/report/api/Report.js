import request from '@/utils/request'

export function postReport (params) {
  return request({
    url: '/student/studentReport',
    method: 'post',
    data: params
  })
}
