package com.blog.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.common.log.annotation.Log;
import com.blog.common.log.enums.BusinessType;
import com.blog.common.security.annotation.RequiresPermissions;
import com.blog.manage.domain.BlogTag;
import com.blog.manage.service.BlogTagService;
import com.blog.common.core.web.controller.BaseController;
import com.blog.common.core.web.domain.AjaxResult;
import com.blog.common.core.utils.poi.ExcelUtil;
import com.blog.common.core.web.page.TableDataInfo;

/**
 * 博客标签Controller
 *
 * @author ytw杨
 * @date 2022-04-14
 */
@RestController
@RequestMapping("/blogTag")
public class BlogTagController extends BaseController
{
    @Autowired
    private BlogTagService blogTagService;

    /**
     * 查询博客标签列表
     */
    @RequiresPermissions("manage:blogTag:list")
    @GetMapping("/list")
    public TableDataInfo list(BlogTag blogTag)
    {
        startPage();
        List<BlogTag> list = blogTagService.selectBlogTagList(blogTag);
        return getDataTable(list);
    }

    /**
     * 导出博客标签列表
     */
    @RequiresPermissions("manage:blogTag:export")
    @Log(title = "博客标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogTag blogTag)
    {
        List<BlogTag> list = blogTagService.selectBlogTagList(blogTag);
        ExcelUtil<BlogTag> util = new ExcelUtil<BlogTag>(BlogTag.class);
        util.exportExcel(response, list, "博客标签数据");
    }

    /**
     * 获取博客标签详细信息
     */
    @RequiresPermissions("manage:blogTag:query")
    @GetMapping(value = "/{uid}")
    public AjaxResult getInfo(@PathVariable("uid") String uid)
    {
        return AjaxResult.success(blogTagService.selectBlogTagByUid(uid));
    }

    /**
     * 新增博客标签
     */
    @RequiresPermissions("manage:blogTag:add")
    @Log(title = "博客标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogTag blogTag)
    {
        return toAjax(blogTagService.insertBlogTag(blogTag));
    }

    /**
     * 修改博客标签
     */
    @RequiresPermissions("manage:blogTag:edit")
    @Log(title = "博客标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogTag blogTag)
    {
        return toAjax(blogTagService.updateBlogTag(blogTag));
    }

    /**
     * 删除博客标签
     */
    @RequiresPermissions("manage:blogTag:remove")
    @Log(title = "博客标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{uids}")
    public AjaxResult remove(@PathVariable String[] uids)
    {
        return toAjax(blogTagService.deleteBlogTagByUids(uids));
    }
}
