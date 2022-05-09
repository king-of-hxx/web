import request from '@/utils/request'

// 查询 整体表格 wtpart 接口
export function getlist () {
  return request({
    url: '/wtpart/list',
    method: 'get'
  })
}

// 查询 树形表格 LinkBOM 接口
export function linkbomlist (id) {
  return request({
    url: '/wtpart/linkbomlist',
    method: 'get',
    params: {
      id: id
    }
  })
}

// 查询历史版本
export function versionHistory (id) {
  return request({
    url: '/wtpart/versionHistory',
    method: 'get',
    params: {
      id: id
    }
  })
}

// export function calculateLayout(data) {
//   return request({
//     url: '/tankTopLevel/calculate',
//     method: 'post',
//     data: data
//   })
// }
