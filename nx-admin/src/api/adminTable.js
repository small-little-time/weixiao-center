import request from '@/utils/request'

export function getUserListPage(params) {
  return request({
    url: '/adm/admAdmins',
    method: 'get',
    params: params
  })
}
export function removeUser(params) {
  return request({
    url: '/adm/admAdmin/' + params.id,
    method: 'delete'
  })
}
export function enableOrDisableUser(params) {
  return request({
    url: '/adm/admAdmin/enableorbatch',
    method: 'put',
    params: params
  })
}
export function batchRemoveUser(params) {
  return request({
    url: '/adm/admAdmin/batchdelete',
    method: 'put',
    params: params
  })
}
export function editUser(params) {
  return request({
    url: '/adm/admAdmin',
    method: 'put',
    data: params
  })
}
export function addUser(params) {
  return request({
    url: '/adm/add',
    method: 'post',
    data: params
  })
}
