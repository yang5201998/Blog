package com.blog.manage.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.common.core.utils.DateUtils;
import com.blog.manage.domain.BlogManage;
import com.blog.manage.mapper.BlogManageMapper;
import com.blog.manage.service.BlogManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 博客Service业务层处理
 *
 * @author blog
 * @date 2022-04-01
 */
@Service
public class BlogManageServiceImpl extends ServiceImpl<BlogManageMapper, BlogManage> implements BlogManageService
{
    @Autowired
    private BlogManageMapper blogManageMapper;

    /**
     * 查询博客
     *
     * @param uid 博客主键
     * @return 博客
     */
    @Override
    public BlogManage selectBlogManageByUid(String uid)
    {
        return blogManageMapper.selectBlogManageByUid(uid);
    }

    /**
     * 查询博客列表
     *
     * @param blogManage 博客
     * @return 博客
     */
    @Override
    public List<BlogManage> selectBlogManageList(BlogManage blogManage)
    {
        return blogManageMapper.selectBlogManageList(blogManage);
    }

    /**
     * 新增博客
     *
     * @param blogManage 博客
     * @return 结果
     */
    @Override
    public int insertBlogManage(BlogManage blogManage)
    {
        blogManage.setCreateTime(DateUtils.getNowDate());
        return blogManageMapper.insertBlogManage(blogManage);
    }

    /**
     * 修改博客
     *
     * @param blogManage 博客
     * @return 结果
     */
    @Override
    public int updateBlogManage(BlogManage blogManage)
    {
        blogManage.setUpdateTime(DateUtils.getNowDate());
        return blogManageMapper.updateBlogManage(blogManage);
    }

    /**
     * 批量删除博客
     *
     * @param uids 需要删除的博客主键
     * @return 结果
     */
    @Override
    public int deleteBlogManageByUids(String[] uids)
    {
        return blogManageMapper.deleteBlogManageByUids(uids);
    }

    /**
     * 删除博客信息
     *
     * @param uid 博客主键
     * @return 结果
     */
    @Override
    public int deleteBlogManageByUid(String uid)
    {
        return blogManageMapper.deleteBlogManageByUid(uid);
    }
}
