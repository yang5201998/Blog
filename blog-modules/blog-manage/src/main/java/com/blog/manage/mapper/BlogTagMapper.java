package com.blog.manage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.manage.domain.BlogTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 博客标签Mapper接口
 * 
 * @author ytw杨
 * @date 2022-04-24
 */
@Mapper
public interface BlogTagMapper extends BaseMapper<BlogTag>
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
     * 删除博客标签
     * 
     * @param uid 博客标签主键
     * @return 结果
     */
    public int deleteBlogTagByUid(String uid);

    /**
     * 批量删除博客标签
     * 
     * @param uids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBlogTagByUids(String[] uids);

    String selectBlogTagUidByUidName(String toString);
}
