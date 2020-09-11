import request from '@/utils/request'

export function getCategory () {
  return request({
    url: '/post/postCategories',
    method: 'get'
  })
}
