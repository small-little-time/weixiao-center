import request from '@/utils/request'

export function upload (params) {
  return request({
    url: '/file/upload',
    method: 'post',
    data: params
  })
}

export function updateFace (params) {
  return request({
    url: '/student/studentMember/updateface',
    method: 'put',
    data: params
  })
}

export function getPostInfo (params) {
  return request({
    url: '/student/studentMember/postinfo',
    method: 'get',
    params: params
  })
}
