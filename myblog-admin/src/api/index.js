import request from '@/utils/request'

//初始化
export function init() {
  return request({
    url: '/system/index/init',
    method: 'get'
  })
}
//获取周访问量和独立用户
export function getVisitByWeek() {
  return request({
    url: '/system/index/visitByWeek',
    method: 'get'
  })
}
//通过标签获取博客数目
export function getBlogCountByTag() {
  return request({
    url: '/system/index/blogCountByTag',
    method: 'get'
  })
}
//通过博客分类获取博客数目
export function getBlogCountByBlogSort() {
  return request({
    url: '/system/index/blogCountByBlogSort',
    method: 'get'
  })
}
//文章贡献度
export function getBlogContributeCount() {
  return request({
    url: '/system/index/blogContributeCount',
    method: 'get'
  })
}
