import request from '@/utils/request'

export function getSettingInfo (id) {
  return request({
    url: '/student/studentSetting',
    method: 'get',
    params: { id }
  })
}

export function updateSetting (params) {
  return request({
    url: '/student/studentSetting',
    method: 'put',
    data: params
  })
}
