package com.blog.blogManage.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blogManage.domain.BlogManage;

import java.util.List;

/**
 * 博客Service接口
 *
 * @author blog
 * @date 2022-04-01
 */
public interface BlogManageService extends IService<BlogManage>
{
    /**
     * 查询博客
     *
     * @param uid 博客主键
     * @return 博客
     */
    public BlogManage selectBlogManageByUid(String uid);

    /**
     * 查询博客列表
     *
     * @param blogManage 博客
     * @return 博客集合
     */
    public List<BlogManage> selectBlogManageList(BlogManage blogManage);

    /**
     * 新增博客
     *
     * @param blogManage 博客
     * @return 结果
     */
    public int insertBlogManage(BlogManage blogManage);

    /**
     * 修改博客
     *
     * @param blogManage 博客
     * @return 结果
     */
    public int updateBlogManage(BlogManage blogManage);

    /**
     * 批量删除博客
     *
     * @param uids 需要删除的博客主键集合
     * @return 结果
     */
    public int deleteBlogManageByUids(String[] uids);

    /**
     * 删除博客信息
     *
     * @param uid 博客主键
     * @return 结果
     */
    public int deleteBlogManageByUid(String uid);
}
