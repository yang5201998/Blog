import request from '@/utils/request'

export function init() {
  return request({
    url: '/system/index/init',
    method: 'get'
  })
}

export function getVisitByWeek() {
  return request({
    url: '/system/index/visitByWeek',
    method: 'get'
  })
}

export function getBlogCountByTag() {
  return request({
    url: '/system/index/getBlogCountByTag',
    method: 'get'
  })
}

export function getBlogCountByBlogSort() {
  return request({
    url: '/system/index/getBlogCountByBlogSort',
    method: 'get'
  })
}

export function getBlogContributeCount() {
  return request({
    url: '/system/index/getBlogContributeCount',
    method: 'get'
  })
}
