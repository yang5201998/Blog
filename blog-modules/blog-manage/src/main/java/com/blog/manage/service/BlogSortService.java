package com.blog.manage.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.manage.domain.BlogSort;

import java.util.List;

/**
 * 博客分类Service接口
 *
 * @author ytw
 * @date 2022-04-06
 */
public interface BlogSortService extends IService<BlogSort>
{
    /**
     * 查询博客分类
     *
     * @param uid 博客分类主键
     * @return 博客分类
     */
    public BlogSort selectBlogSortByUid(String uid);

    /**
     * 查询博客分类列表
     *
     * @param blogSort 博客分类
     * @return 博客分类集合
     */
    public List<BlogSort> selectBlogSortList(BlogSort blogSort);

    /**
     * 新增博客分类
     *
     * @param blogSort 博客分类
     * @return 结果
     */
    public int insertBlogSort(BlogSort blogSort);

    /**
     * 修改博客分类
     *
     * @param blogSort 博客分类
     * @return 结果
     */
    public int updateBlogSort(BlogSort blogSort);

    /**
     * 批量删除博客分类
     *
     * @param uids 需要删除的博客分类主键集合
     * @return 结果
     */
    public int deleteBlogSortByUids(String[] uids);

    /**
     * 删除博客分类信息
     *
     * @param uid 博客分类主键
     * @return 结果
     */
    public int deleteBlogSortByUid(String uid);
}
