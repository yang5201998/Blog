package com.blog.manage.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.manage.domain.BlogSort;
import org.apache.ibatis.annotations.Mapper;

/**
 * 博客分类Mapper接口
 *
 * @author ytw
 * @date 2022-04-06
 */
@Mapper
public interface BlogSortMapper extends BaseMapper<BlogSort>
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
     * 删除博客分类
     *
     * @param uid 博客分类主键
     * @return 结果
     */
    public int deleteBlogSortByUid(String uid);

    /**
     * 批量删除博客分类
     *
     * @param uids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBlogSortByUids(String[] uids);
}
