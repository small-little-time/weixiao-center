import request from '@/utils/request'

export function getStudentListPage(params) {
  return request({
    url: '/student/studentMembers',
    method: 'get',
    params: params
  })
}
export function removeStudent(params) {
  return request({
    url: '/student/studentMember/' + params.id,
    method: 'delete'
  })
}
export function disableOrEnableStudent(params) {
  return request({
    url: '/student/studentMember/disableorenable/' + params.id,
    method: 'put'
  })
}
export function batchRemoveStudent(params) {
  return request({
    url: '/student/studentMember/batchdelete',
    method: 'put',
    params: params
  })
}
