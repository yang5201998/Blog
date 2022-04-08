import request from '@/utils/request'

// 查询角色列表
export function listBlogManage(query) {
    return request({
      url: '/manage/blogManage/list',
      method: 'get',
      params: query
    })
  }