import request from '@/utils/request'

export function getReportListPage(params) {
  return request({
    url: '/student/studentReports',
    method: 'get',
    params: params
  })
}
export function removeReport(params) {
  return request({
    url: '/student/studentReport/' + params.id,
    method: 'delete',
    params: params
  })
}
export function reply(params) {
  return request({
    url: '/student/studentReport/reply',
    method: 'put',
    params: params
  })
}
export function batchReply(params) {
  return request({
    url: '/student/studentReport/batchreply',
    method: 'put',
    params: params
  })
}
