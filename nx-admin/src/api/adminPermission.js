import request from '@/utils/request'

export function getAdminRolesList(params) {
  return request({
    url: '/adm/admAdmin/roles',
    method: 'get',
    params: params
  })
}
export function removeRelation(params) {
  return request({
    url: '/adm/admAdminRoleRelation/delete',
    method: 'delete',
    params: params
  })
}
export function batchRemoveRelation(params) {
  return request({
    url: '/adm/admAdminRoleRelation/batchdelete',
    method: 'delete',
    params: params
  })
}
export function addRelation(params) {
  return request({
    url: '/adm/admAdminRoleRelation',
    method: 'post',
    data: params
  })
}
export function getAllRoles(params) {
  return request({
    url: '/adm/admRoles',
    method: 'get',
    params: params
  })
}
export function getAllAdmins(params) {
  return request({
    url: '/adm/admAdmins',
    method: 'get',
    params: params
  })
}
