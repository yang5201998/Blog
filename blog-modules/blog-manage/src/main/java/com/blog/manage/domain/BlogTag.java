package com.blog.manage.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blog.common.core.annotation.Excel;
import com.blog.common.core.web.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 博客标签对象 back_tag
 *
 * @author ytw杨
 * @date 2022-04-14
 */
@Data
@TableName("back_tag")
public class BlogTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一uid */
    private String uid;

    /** 标签内容 */
    @Excel(name = "标签内容")
    private String content;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 标签简介 */
    @Excel(name = "标签简介")
    private Long clickCount;

    /** 排序字段，越大越靠前 */
    @Excel(name = "排序字段，越大越靠前")
    private Long sort;

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getUid()
    {
        return uid;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setClickCount(Long clickCount)
    {
        this.clickCount = clickCount;
    }

    public Long getClickCount()
    {
        return clickCount;
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
            .append("content", getContent())
            .append("status", getStatus())
            .append("clickCount", getClickCount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("sort", getSort())
            .toString();
    }
}
