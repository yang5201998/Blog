package com.blog.manage.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blog.common.core.annotation.Excel;
import com.blog.common.core.web.domain.BaseEntity;
import com.blog.common.core.web.domain.BlogEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 博客标签对象 back_tag
 *
 * @author ytw杨
 * @date 2022-04-24
 */
@TableName("back_tag")
public class BlogTag extends BlogEntity
{
    private static final long serialVersionUID = 1L;

    //序号
    @TableField(exist = false)
    private Long id;

    /** 唯一uid */
    private String uid;

    /** 标签内容 */
    @Excel(name = "标签内容")
    private String tagName;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 标签使用量 */
    @Excel(name = "标签使用量")
    private Long tagUsed;

    /** 排序字段，越大越靠前 */
    @Excel(name = "排序字段，越大越靠前")
    private Long sort;

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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setTagUsed(Long tagUsed)
    {
        this.tagUsed = tagUsed;
    }

    public Long getTagUsed()
    {
        return tagUsed;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uid", getUid())
            .append("tagName", getTagName())
            .append("status", getStatus())
            .append("tagUsed", getTagUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("sort", getSort())
            .toString();
    }
}
