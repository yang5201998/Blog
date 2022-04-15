package com.blog.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.common.core.utils.DateUtils;
import com.blog.manage.domain.BlogManage;
import com.blog.manage.domain.BlogSort;
import com.blog.manage.domain.BlogTag;
import com.blog.manage.mapper.BlogManageMapper;
import com.blog.manage.mapper.BlogSortMapper;
import com.blog.manage.mapper.BlogTagMapper;
import com.blog.manage.service.BlogManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



/**
 * 博客管理Service业务层处理
 *
 * @author ytw杨
 * @date 2022-04-11
 */
@Service
public class BlogManageServiceImpl extends ServiceImpl<BlogManageMapper, BlogManage> implements BlogManageService
{
    @Autowired
    private BlogManageMapper blogManageMapper;

    @Autowired
    private BlogSortMapper blogSortMapper;

    @Autowired
    private BlogTagMapper blogTagMapper;
    /**
     * 查询博客管理
     *
     * @param uid 博客管理主键
     * @return 博客管理
     */
    @Override
    public BlogManage selectBlogManageByUid(String uid)
    {
        return blogManageMapper.selectBlogManageByUid(uid);
    }

    /**
     * 查询博客管理列表
     *
     * @param blogManage 博客管理
     * @return 博客管理
     */
    @Override
    public List<BlogManage> selectBlogManageList(BlogManage blogManage)
    {
        List<BlogManage> blogManages = blogManageMapper.selectBlogManageVoList(blogManage);
        for (BlogManage blogManager : blogManages){
            List list1 = new ArrayList();
            List list2 = new ArrayList();
            //获取博客分类名称
            String blogSortUid = blogManager.getBlogSortUid();
            String[] split1 = blogSortUid.split(",");
            for (int i = 0; i < split1.length; i++) {
                BlogSort blogSort = blogSortMapper.selectBlogSortByUid(split1[i]);
                list1.add(blogSort);
            }
            //获取博客标签名称
            String tagUid = blogManager.getTagUid();
            String[] split2 = tagUid.split(",");
            for (int i = 0; i < split2.length; i++) {
                BlogTag blogTag = blogTagMapper.selectBlogTagByUid(split2[i]);
                list2.add(blogTag);
            }
            //获取博客推荐等级

            blogManager.setBlogSortName(list1);
            blogManager.setBlogTagName(list2);
        }
        return blogManages;
    }

    /**
     * 新增博客管理
     *
     * @param blogManage 博客管理
     * @return 结果
     */
    @Override
    public int insertBlogManage(BlogManage blogManage)
    {
        blogManage.setCreateTime(DateUtils.getNowDate());
        return blogManageMapper.insertBlogManage(blogManage);
    }

    /**
     * 修改博客管理
     *
     * @param blogManage 博客管理
     * @return 结果
     */
    @Override
    public int updateBlogManage(BlogManage blogManage)
    {
        blogManage.setUpdateTime(DateUtils.getNowDate());
        return blogManageMapper.updateBlogManage(blogManage);
    }

    /**
     * 批量删除博客管理
     *
     * @param uids 需要删除的博客管理主键
     * @return 结果
     */
    @Override
    public int deleteBlogManageByUids(String[] uids)
    {
        return blogManageMapper.deleteBlogManageByUids(uids);
    }

    /**
     * 删除博客管理信息
     *
     * @param uid 博客管理主键
     * @return 结果
     */
    @Override
    public int deleteBlogManageByUid(String uid)
    {
        return blogManageMapper.deleteBlogManageByUid(uid);
    }
}
