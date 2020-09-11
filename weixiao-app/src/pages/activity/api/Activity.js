import request from '@/utils/request'

export function getActivity (params) {
  return request({
    url: '/post/app/postActivities',
    method: 'get',
    params: params
  })
}
