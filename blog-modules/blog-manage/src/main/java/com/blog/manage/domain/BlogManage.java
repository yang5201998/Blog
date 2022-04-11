package com.blog.manage.domain;

import com.blog.common.core.annotation.Excel;
import com.blog.common.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 博客管理对象 back_blog
 *
 * @author ytw杨
 * @date 2022-04-11
 */
public class BlogManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    //序号
    private Long id;
    /** 唯一uid */
    private String uid;

    /** 博客标题 */
    @Excel(name = "博客标题")
    private String blogTitle;

    /** 博客简介 */
    @Excel(name = "博客简介")
    private String summary;

    /** 博客内容 */
    @Excel(name = "博客内容")
    private String content;

    /** 标签uid */
    @Excel(name = "标签uid")
    private String tagUid;

    /** 博客点击数 */
    @Excel(name = "博客点击数")
    private Long clickCount;

    /** 博客收藏数 */
    @Excel(name = "博客收藏数")
    private Long collectCount;

    /** 标题图片uid */
    @Excel(name = "标题图片uid")
    private String fileUid;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 管理员uid */
    @Excel(name = "管理员uid")
    private String adminUid;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 博客分类UID */
    @Excel(name = "博客分类UID")
    private String blogSortUid;

    /** 推荐等级(0:正常) */
    @Excel(name = "推荐等级(0:正常)")
    private Integer level;

    /** 是否发布：0：否，1：是 */
    @Excel(name = "是否发布：0：否，1：是")
    private String isPublish;

    /** 排序字段 */
    @Excel(name = "排序字段")
    private Long sort;

    /** 是否开启评论(0:否 1:是) */
    @Excel(name = "是否开启评论(0:否 1:是)")
    private Integer openComment;

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getUid()
    {
        return uid;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSummary()
    {
        return summary;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setTagUid(String tagUid)
    {
        this.tagUid = tagUid;
    }

    public String getTagUid()
    {
        return tagUid;
    }
    public void setClickCount(Long clickCount)
    {
        this.clickCount = clickCount;
    }

    public Long getClickCount()
    {
        return clickCount;
    }
    public void setCollectCount(Long collectCount)
    {
        this.collectCount = collectCount;
    }

    public Long getCollectCount()
    {
        return collectCount;
    }
    public void setFileUid(String fileUid)
    {
        this.fileUid = fileUid;
    }

    public String getFileUid()
    {
        return fileUid;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setAdminUid(String adminUid)
    {
        this.adminUid = adminUid;
    }

    public String getAdminUid()
    {
        return adminUid;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }
    public void setBlogSortUid(String blogSortUid)
    {
        this.blogSortUid = blogSortUid;
    }

    public String getBlogSortUid()
    {
        return blogSortUid;
    }
    public void setLevel(Integer level)
    {
        this.level = level;
    }

    public Integer getLevel()
    {
        return level;
    }
    public void setIsPublish(String isPublish)
    {
        this.isPublish = isPublish;
    }

    public String getIsPublish()
    {
        return isPublish;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }
    public void setOpenComment(Integer openComment)
    {
        this.openComment = openComment;
    }

    public Integer getOpenComment()
    {
        return openComment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uid", getUid())
            .append("blogTitle", getBlogTitle())
            .append("summary", getSummary())
            .append("content", getContent())
            .append("tagUid", getTagUid())
            .append("clickCount", getClickCount())
            .append("collectCount", getCollectCount())
            .append("fileUid", getFileUid())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("adminUid", getAdminUid())
            .append("author", getAuthor())
            .append("blogSortUid", getBlogSortUid())
            .append("level", getLevel())
            .append("isPublish", getIsPublish())
            .append("sort", getSort())
            .append("openComment", getOpenComment())
            .toString();
    }
}
