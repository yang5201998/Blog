package com.blog.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.manage.domain.BlogManage;

import java.util.List;

/**
 * 博客管理Service接口
 *
 * @author ytw杨
 * @date 2022-04-11
 */
public interface BlogManageService extends IService<BlogManage>
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
     * 批量删除博客管理
     *
     * @param uids 需要删除的博客管理主键集合
     * @return 结果
     */
    public int deleteBlogManageByUids(String[] uids);

    /**
     * 删除博客管理信息
     *
     * @param uid 博客管理主键
     * @return 结果
     */
    public int deleteBlogManageByUid(String uid);
}
