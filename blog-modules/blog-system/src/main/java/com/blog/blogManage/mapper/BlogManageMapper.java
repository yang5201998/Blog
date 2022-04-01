package com.blog.blogManage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.blogManage.domain.BlogManage;

import java.util.List;


/**
 * 博客Mapper接口
 *
 * @author blog
 * @date 2022-04-01
 */
@org.apache.ibatis.annotations.Mapper
public interface BlogManageMapper extends BaseMapper<BlogManage>
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
     * @param BlogManage 博客
     * @return 博客集合
     */
    public List<BlogManage> selectBlogManageList(BlogManage BlogManage);

    /**
     * 新增博客
     *
     * @param BlogManage 博客
     * @return 结果
     */
    public int insertBlogManage(BlogManage BlogManage);

    /**
     * 修改博客
     *
     * @param BlogManage 博客
     * @return 结果
     */
    public int updateBlogManage(BlogManage BlogManage);

    /**
     * 删除博客
     *
     * @param uid 博客主键
     * @return 结果
     */
    public int deleteBlogManageByUid(String uid);

    /**
     * 批量删除博客
     *
     * @param uids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBlogManageByUids(String[] uids);
}
