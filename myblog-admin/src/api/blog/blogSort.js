import request from '@/utils/request'

// 查询博客分类列表
export function listBlogSort(query) {
  return request({
    url: '/manage/blogSort/list',
    method: 'get',
    params: query
  })
}

// 查询博客分类详细
export function getBlogSort(uid) {
  return request({
    url: '/manage/blogSort/' + uid,
    method: 'get'
  })
}
// 博客分类状态修改
export function changeBlogSortStatus(uid, status) {
  const data = {
    uid,
    status
  }
  return request({
    url: '/manage/blogSort/changeStatus',
    method: 'put',
    data: data
  })
}
// 新增博客分类
export function addBlogSort(data) {
  return request({
    url: '/manage/blogSort',
    method: 'post',
    data: data
  })
}

// 修改博客分类
export function updateBlogSort(data) {
  return request({
    url: '/manage/blogSort/edit',
    method: 'put',
    data: data
  })
}

// 删除博客分类
export function delBlogSort(uid) {
  return request({
    url: '/manage/blogSort/' + uid,
    method: 'delete'
  })
}
