package com.blog.manage.domain;

import com.blog.common.core.annotation.Excel;
import com.blog.common.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 博客对象 back_blog
 *
 * @author blog
 * @date 2022-04-01
 */
public class BlogManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一uid */
    private String uid;

    /** 博客标题 */
    @Excel(name = "博客标题")
    private String title;

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

    /** 是否原创（0:不是 1：是） */
    @Excel(name = "是否原创", readConverterExp = "0=:不是,1=：是")
    private String isOriginal;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 文章出处 */
    @Excel(name = "文章出处")
    private String articlesPart;

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

    /** 类型【0 博客， 1：推广】 */
    @Excel(name = "类型【0 博客， 1：推广】")
    private Integer type;

    /** 外链【如果是推广，那么将跳转到外链】 */
    @Excel(name = "外链【如果是推广，那么将跳转到外链】")
    private String outsideLink;

    /** 唯一oid */
    private Long oid;

    /** 投稿用户UID */
    @Excel(name = "投稿用户UID")
    private String userUid;

    /** 文章来源【0 后台添加，1 用户投稿】 */
    @Excel(name = "文章来源【0 后台添加，1 用户投稿】")
    private Integer articleSource;

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getUid()
    {
        return uid;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
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
    public void setIsOriginal(String isOriginal)
    {
        this.isOriginal = isOriginal;
    }

    public String getIsOriginal()
    {
        return isOriginal;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }
    public void setArticlesPart(String articlesPart)
    {
        this.articlesPart = articlesPart;
    }

    public String getArticlesPart()
    {
        return articlesPart;
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
    public void setType(Integer type)
    {
        this.type = type;
    }

    public Integer getType()
    {
        return type;
    }
    public void setOutsideLink(String outsideLink)
    {
        this.outsideLink = outsideLink;
    }

    public String getOutsideLink()
    {
        return outsideLink;
    }
    public void setOid(Long oid)
    {
        this.oid = oid;
    }

    public Long getOid()
    {
        return oid;
    }
    public void setUserUid(String userUid)
    {
        this.userUid = userUid;
    }

    public String getUserUid()
    {
        return userUid;
    }
    public void setArticleSource(Integer articleSource)
    {
        this.articleSource = articleSource;
    }

    public Integer getArticleSource()
    {
        return articleSource;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("uid", getUid())
            .append("title", getTitle())
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
            .append("isOriginal", getIsOriginal())
            .append("author", getAuthor())
            .append("articlesPart", getArticlesPart())
            .append("blogSortUid", getBlogSortUid())
            .append("level", getLevel())
            .append("isPublish", getIsPublish())
            .append("sort", getSort())
            .append("openComment", getOpenComment())
            .append("type", getType())
            .append("outsideLink", getOutsideLink())
            .append("oid", getOid())
            .append("userUid", getUserUid())
            .append("articleSource", getArticleSource())
            .toString();
    }
}
