import request from '@/utils/request'

// 查询博客管理列表
export function listBlogManage(query) {
  return request({
    url: '/manage/blogManage/list',
    method: 'get',
    params: query
  })
}
// 获取博客分类和标签列表
export function listSortAndTag() {
  return request({
    url: '/manage/blogManage/sortAndTag',
    method: 'get',
  })
}
// 查询博客管理详细
export function getBlogManage(uid) {
  return request({
    url: '/manage/blogManage/' + uid,
    method: 'get'
  })
}

// 新增博客管理
export function addBlogManage(data) {
  return request({
    url: '/manage/blogManage',
    method: 'post',
    data: data
  })
}

// 修改博客管理
export function updateBlogManage(data) {
  return request({
    url: '/manage/blogManage/edit',
    method: 'put',
    data: data
  })
}

// 删除博客管理
export function delBlogManage(uid) {
  return request({
    url: '/manage/blogManage/' + uid,
    method: 'delete'
  })
}
