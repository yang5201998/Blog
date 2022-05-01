import request from '@/utils/request'

// 查询博客标签列表
export function listBlogTag(query) {
  return request({
    url: '/manage/blogTag/list',
    method: 'get',
    params: query
  })
}

// 查询博客标签详细
export function getBlogTag(uid) {
  return request({
    url: '/manage/blogTag/' + uid,
    method: 'get'
  })
}

// 新增博客标签
export function addBlogTag(data) {
  return request({
    url: '/manage/blogTag',
    method: 'post',
    data: data
  })
}

// 修改博客标签
export function updateBlogTag(data) {
  return request({
    url: '/manage/blogTag',
    method: 'put',
    data: data
  })
}

// 删除博客标签
export function delBlogTag(uid) {
  return request({
    url: '/manage/blogTag/' + uid,
    method: 'delete'
  })
}
