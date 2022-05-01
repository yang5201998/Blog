package com.blog.manage.service.impl;

import java.util.List;
import java.util.UUID;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.common.core.utils.DateUtils;
import com.blog.common.security.utils.SecurityUtils;
import com.blog.manage.service.BlogSortService;
import com.blog.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.stereotype.Service;
import com.blog.manage.mapper.BlogSortMapper;
import com.blog.manage.domain.BlogSort;

/**
 * 博客分类Service业务层处理
 *
 * @author ytw
 * @date 2022-04-06
 */
@Service
public class BlogSortServiceImpl extends ServiceImpl<BlogSortMapper,BlogSort> implements BlogSortService
{
    @Autowired
    private BlogSortMapper blogSortMapper;

    /**
     * 查询博客分类
     *
     * @param uid 博客分类主键
     * @return 博客分类
     */
    @Override
    public BlogSort selectBlogSortByUid(String uid)
    {
        return blogSortMapper.selectBlogSortByUid(uid);
    }

    /**
     * 查询博客分类列表
     *
     * @param blogSort 博客分类
     * @return 博客分类
     */
    @Override
    public List<BlogSort> selectBlogSortList(BlogSort blogSort)
    {
        return blogSortMapper.selectBlogSortList(blogSort);
    }

    /**
     * 新增博客分类
     *
     * @param blogSort 博客分类
     * @return 结果
     */
    @Override
    public int insertBlogSort(BlogSort blogSort)
    {
        if (blogSort.getUid()==null || (" ").equals(blogSort.getUid())){
            String uuid = UUID.randomUUID().toString().replace("-", "");
            blogSort.setUid(uuid);
        }
        LoginUser loginUser = SecurityUtils.getLoginUser();
        String username = loginUser.getUsername();
        blogSort.setCreateBy(username);
        blogSort.setCreateTime(DateUtils.getNowDate());
        return blogSortMapper.insertBlogSort(blogSort);
    }

    /**
     * 修改博客分类
     *
     * @param blogSort 博客分类
     * @return 结果
     */
    @Override
    public int updateBlogSort(BlogSort blogSort)
    {
        blogSort.setUpdateTime(DateUtils.getNowDate());
        return blogSortMapper.updateBlogSort(blogSort);
    }

    /**
     * 批量删除博客分类
     *
     * @param uids 需要删除的博客分类主键
     * @return 结果
     */
    @Override
    public int deleteBlogSortByUids(String[] uids)
    {
        return blogSortMapper.deleteBlogSortByUids(uids);
    }

    /**
     * 删除博客分类信息
     *
     * @param uid 博客分类主键
     * @return 结果
     */
    @Override
    public int deleteBlogSortByUid(String uid)
    {
        return blogSortMapper.deleteBlogSortByUid(uid);
    }

    /**
    * 博客分类状态修改
    * @author ytw杨
    * @date 9/4/2022 下午11:55
    * @param [blogSort]
    * @return int
    */
    @Override
    public int updateBlogSortStatus(BlogSort blogSort) {
        return blogSortMapper.updateBlogSort(blogSort);
    }
}
