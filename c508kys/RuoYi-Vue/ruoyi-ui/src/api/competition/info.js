import request from '@/utils/request'

// 查询比赛信息列表
export function listInfo(query) {
  return request({
    url: '/competition/info/list',
    method: 'get',
    params: query
  })
}

// 查询比赛信息详细
export function getInfo(id) {
  return request({
    url: '/competition/info/' + id,
    method: 'get'
  })
}

// 新增比赛信息
export function addInfo(data) {
  return request({
    url: '/competition/info',
    method: 'post',
    data: data
  })
}

// 修改比赛信息
export function updateInfo(data) {
  return request({
    url: '/competition/info',
    method: 'put',
    data: data
  })
}

// 删除比赛信息
export function delInfo(id) {
  return request({
    url: '/competition/info/' + id,
    method: 'delete'
  })
}
