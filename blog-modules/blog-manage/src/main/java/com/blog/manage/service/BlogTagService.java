package com.blog.manage.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.manage.domain.BlogTag;

import java.util.List;

/**
 * 博客标签Service接口
 *
 * @author ytw杨
 * @date 2022-04-24
 */
public interface BlogTagService extends IService<BlogTag>
{
    /**
     * 查询博客标签
     *
     * @param uid 博客标签主键
     * @return 博客标签
     */
    public BlogTag selectBlogTagByUid(String uid);

    /**
     * 查询博客标签列表
     *
     * @param blogTag 博客标签
     * @return 博客标签集合
     */
    public List<BlogTag> selectBlogTagList(BlogTag blogTag);

    /**
     * 新增博客标签
     *
     * @param blogTag 博客标签
     * @return 结果
     */
    public int insertBlogTag(BlogTag blogTag);

    /**
     * 修改博客标签
     *
     * @param blogTag 博客标签
     * @return 结果
     */
    public int updateBlogTag(BlogTag blogTag);

    /**
     * 批量删除博客标签
     *
     * @param uids 需要删除的博客标签主键集合
     * @return 结果
     */
    public int deleteBlogTagByUids(String[] uids);

    /**
     * 删除博客标签信息
     *
     * @param uid 博客标签主键
     * @return 结果
     */
    public int deleteBlogTagByUid(String uid);
}
