package com.blog.manage.domain;

import com.blog.common.core.annotation.Excel;
import com.blog.common.core.web.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * 博客分类对象 back_blog_sort
 *
 * @author ytw
 * @date 2022-04-06
 */
@Data
public class BlogSort extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    //序号
    private Long id;
    /** 唯一uid */
    private String uid;

    /** 分类内容 */
    @Excel(name = "分类内容")
    private String blogSortName;

    /** 分类简介 */
    @Excel(name = "分类简介")
    private String blogSortContent;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 分类排序 */
    @Excel(name = "分类排序")
    private Long blogSorts;

    /** 文章引用数 */
    @Excel(name = "文章引用数")
    private Long blogSortSum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getUid()
    {
        return uid;
    }
    public void setBlogSortName(String blogSortName)
    {
        this.blogSortName = blogSortName;
    }

    public String getBlogSortName()
    {
        return blogSortName;
    }
    public void setBlogSortContent(String blogSortContent)
    {
        this.blogSortContent = blogSortContent;
    }

    public String getBlogSortContent()
    {
        return blogSortContent;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setBlogSorts(Long blogSorts)
    {
        this.blogSorts = blogSorts;
    }

    public Long getBlogSorts()
    {
        return blogSorts;
    }
    public void setBlogSortSum(Long blogSortSum)
    {
        this.blogSortSum = blogSortSum;
    }

    public Long getBlogSortSum()
    {
        return blogSortSum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uid", getUid())
            .append("blogSortName", getBlogSortName())
            .append("blogSortContent", getBlogSortContent())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("blogSorts", getBlogSorts())
            .append("blogSortSum", getBlogSortSum())
            .toString();
    }
}