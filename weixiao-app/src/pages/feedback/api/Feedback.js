import request from '@/utils/request'

export function postFeedback (params) {
  return request({
    url: '/student/studentFeedback',
    method: 'post',
    data: params
  })
}
