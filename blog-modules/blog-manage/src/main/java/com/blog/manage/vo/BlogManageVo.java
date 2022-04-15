package com.blog.manage.vo;

import com.blog.common.core.annotation.Excel;
import com.blog.common.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 博客管理对象 back_blog vo层
 *
 * @author ytw杨
 * @date 2022-04-11
 */
public class BlogManageVo extends BaseEntity
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

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String blogTagName;

    /** 博客点击数 */
    @Excel(name = "博客点击数")
    private Long clickCount;

    /** 博客收藏数 */
    @Excel(name = "博客收藏数")
    private Long collectCount;

    /** 标题图片 */
    @Excel(name = "标题图片")
    private String blogImg;

    /** 图片url */
    private String url;
    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 博客分类UID */
    @Excel(name = "博客分类")
    private String blogSortName;

    /** 推荐等级(0:正常) */
    @Excel(name = "推荐等级(0:正常)")
    private Integer level;

    /** 排序字段 */
    @Excel(name = "排序字段")
    private Long sort;

    /** 是否开启评论(0:否 1:是) */
    @Excel(name = "是否开启评论(0:否 1:是)")
    private Integer openComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBlogTagName() {
        return blogTagName;
    }

    public void setBlogTagName(String blogTagName) {
        this.blogTagName = blogTagName;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Long getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Long collectCount) {
        this.collectCount = collectCount;
    }

    public String getBlogImg() {
        return blogImg;
    }

    public void setBlogImg(String blogImg) {
        this.blogImg = blogImg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlogSortName() {
        return blogSortName;
    }

    public void setBlogSortName(String blogSortName) {
        this.blogSortName = blogSortName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Integer getOpenComment() {
        return openComment;
    }

    public void setOpenComment(Integer openComment) {
        this.openComment = openComment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("uid", getUid())
                .append("blogTitle", getBlogTitle())
                .append("summary", getSummary())
                .append("content", getContent())
                .append("blogTagName", getBlogTagName())
                .append("clickCount", getClickCount())
                .append("collectCount", getCollectCount())
                .append("blogImg", getBlogImg())
                .append("url", getUrl())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("author", getAuthor())
                .append("blogSortName", getBlogSortName())
                .append("level", getLevel())
                .append("sort", getSort())
                .append("openComment", getOpenComment())
                .toString();
    }
}
