package com.blog.manage.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.manage.domain.BlogManage;

/**
 * 博客管理Mapper接口
 *
 * @author ytw杨
 * @date 2022-04-11
 */
@org.apache.ibatis.annotations.Mapper
public interface BlogManageMapper extends BaseMapper<BlogManage>
{
    /**
     * 查询博客管理
     *
     * @param uid 博客管理主键
     * @return 博客管理
     */
    public BlogManage selectBlogManageByUid(String uid);

    /**
     * 查询博客管理列表
     *
     * @param blogManage 博客管理
     * @return 博客管理集合
     */
    public List<BlogManage> selectBlogManageList(BlogManage blogManage);

    /**
     * 新增博客管理
     *
     * @param blogManage 博客管理
     * @return 结果
     */
    public int insertBlogManage(BlogManage blogManage);

    /**
     * 修改博客管理
     *
     * @param blogManage 博客管理
     * @return 结果
     */
    public int updateBlogManage(BlogManage blogManage);

    /**
     * 删除博客管理
     *
     * @param uid 博客管理主键
     * @return 结果
     */
    public int deleteBlogManageByUid(String uid);

    /**
     * 批量删除博客管理
     *
     * @param uids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBlogManageByUids(String[] uids);
}
