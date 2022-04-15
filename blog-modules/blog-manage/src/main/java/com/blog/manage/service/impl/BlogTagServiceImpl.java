package com.blog.manage.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.manage.mapper.BlogTagMapper;
import com.blog.manage.domain.BlogTag;
import com.blog.manage.service.BlogTagService;

/**
 * 博客标签Service业务层处理
 *
 * @author ytw杨
 * @date 2022-04-14
 */
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper,BlogTag> implements BlogTagService
{
    @Autowired
    private BlogTagMapper blogTagMapper;

    /**
     * 查询博客标签
     *
     * @param uid 博客标签主键
     * @return 博客标签
     */
    @Override
    public BlogTag selectBlogTagByUid(String uid)
    {
        return blogTagMapper.selectBlogTagByUid(uid);
    }

    /**
     * 查询博客标签列表
     *
     * @param blogTag 博客标签
     * @return 博客标签
     */
    @Override
    public List<BlogTag> selectBlogTagList(BlogTag blogTag)
    {
        return blogTagMapper.selectBlogTagList(blogTag);
    }

    /**
     * 新增博客标签
     *
     * @param blogTag 博客标签
     * @return 结果
     */
    @Override
    public int insertBlogTag(BlogTag blogTag)
    {
        blogTag.setCreateTime(DateUtils.getNowDate());
        return blogTagMapper.insertBlogTag(blogTag);
    }

    /**
     * 修改博客标签
     *
     * @param blogTag 博客标签
     * @return 结果
     */
    @Override
    public int updateBlogTag(BlogTag blogTag)
    {
        blogTag.setUpdateTime(DateUtils.getNowDate());
        return blogTagMapper.updateBlogTag(blogTag);
    }

    /**
     * 批量删除博客标签
     *
     * @param uids 需要删除的博客标签主键
     * @return 结果
     */
    @Override
    public int deleteBlogTagByUids(String[] uids)
    {
        return blogTagMapper.deleteBlogTagByUids(uids);
    }

    /**
     * 删除博客标签信息
     *
     * @param uid 博客标签主键
     * @return 结果
     */
    @Override
    public int deleteBlogTagByUid(String uid)
    {
        return blogTagMapper.deleteBlogTagByUid(uid);
    }
}
