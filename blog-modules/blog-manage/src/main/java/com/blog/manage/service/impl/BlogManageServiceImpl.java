package com.blog.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.common.core.utils.DateUtils;
import com.blog.common.core.utils.StringUtils;
import com.blog.manage.domain.BlogManage;
import com.blog.manage.domain.BlogSort;
import com.blog.manage.domain.BlogTag;
import com.blog.manage.mapper.BlogManageMapper;
import com.blog.manage.mapper.BlogSortMapper;
import com.blog.manage.mapper.BlogTagMapper;
import com.blog.manage.service.BlogManageService;
import com.blog.manage.service.BlogSortService;
import com.blog.manage.service.BlogTagService;
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
    private BlogManageService blogManageService;

    @Autowired
    private BlogSortMapper blogSortMapper;

    @Autowired
    private BlogSortService blogSortService;
    @Autowired
    private BlogTagService blogTagService;
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
        //通过博客分类名称查询结果
        if (StringUtils.isNotEmpty(blogManage.getBlogSortName())){
            StringBuilder stringBuilderSort=new StringBuilder();
            List blogSortName = blogManage.getBlogSortName();
            blogSortName.forEach(item->{
                String sortUid = blogSortMapper.selectBlogSortUidByName(item.toString());
                stringBuilderSort.append(sortUid);
                stringBuilderSort.append(",");
            });
            blogManage.setBlogSortUid(stringBuilderSort.deleteCharAt(stringBuilderSort.lastIndexOf(",")).toString());
        }
        //通过博客标签名称查询结果
        if (StringUtils.isNotEmpty(blogManage.getBlogTagName())){
            StringBuilder stringBuilderTag=new StringBuilder();
            List blogTagName = blogManage.getBlogTagName();
                blogTagName.forEach(item->{
                String tagUid =blogTagMapper.selectBlogTagUidByUidName(item.toString());
                stringBuilderTag.append(tagUid);
                stringBuilderTag.append(",");
            });
            blogManage.setTagUid(stringBuilderTag.deleteCharAt(stringBuilderTag.lastIndexOf(",")).toString());
        }
        List<BlogManage> blogManages = blogManageMapper.selectBlogManageVoList(blogManage);
        if (StringUtils.isNotEmpty(blogManages)) {
            blogManages.forEach(item -> {
                List<BlogSort> blogSortNames = new ArrayList();
                List<BlogTag> blogTagNames = new ArrayList();
                //获取博客分类名称
                if (StringUtils.isNotEmpty(item.getBlogSortUid())) {
                    String[] splitSortUid = item.getBlogSortUid().split(",");
                    for (int i = 0; i < splitSortUid.length; i++) {
                        BlogSort blogSort = blogSortMapper.selectBlogSortByUid(splitSortUid[i]);
                        blogSortNames.add(blogSort);
                    }
                }
                //获取博客标签名称
                if (StringUtils.isNotEmpty(item.getTagUid())) {
                    String[] splitTagUid = item.getTagUid().split(",");
                    for (int i = 0; i < splitTagUid.length; i++) {
                        BlogTag blogTag = blogTagMapper.selectBlogTagByUid(splitTagUid[i]);
                        blogTagNames.add(blogTag);
                    }
                }
                item.setBlogSortName(blogSortNames);
                item.setBlogTagName(blogTagNames);
            });
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
