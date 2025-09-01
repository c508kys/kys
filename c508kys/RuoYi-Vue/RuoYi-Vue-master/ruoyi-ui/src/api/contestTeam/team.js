import request from '@/utils/request'

// 查询组队信息列表
export function listTeam(query) {
  return request({
    url: '/contestTeam/team/list',
    method: 'get',
    params: query
  })
}

// 查询组队信息详细
export function getTeam(id) {
  return request({
    url: '/contestTeam/team/' + id,
    method: 'get'
  })
}

// 新增组队信息
export function addTeam(data) {
  return request({
    url: '/contestTeam/team',
    method: 'post',
    data: data
  })
}

// 修改组队信息
export function updateTeam(data) {
  return request({
    url: '/contestTeam/team',
    method: 'put',
    data: data
  })
}

// 删除组队信息
export function delTeam(id) {
  return request({
    url: '/contestTeam/team/' + id,
    method: 'delete'
  })
}
