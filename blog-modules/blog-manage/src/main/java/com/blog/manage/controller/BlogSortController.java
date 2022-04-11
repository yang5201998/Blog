package com.blog.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.blog.manage.service.BlogSortService;
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
import com.blog.manage.domain.BlogSort;
import com.blog.manage.service.BlogSortService;
import com.blog.common.core.web.controller.BaseController;
import com.blog.common.core.web.domain.AjaxResult;
import com.blog.common.core.utils.poi.ExcelUtil;
import com.blog.common.core.web.page.TableDataInfo;

/**
 * 博客分类Controller
 *
 * @author ytw
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/blogSort")
public class BlogSortController extends BaseController
{
    @Autowired
    private BlogSortService blogSortService;

    /**
     * 查询博客分类列表
     */
    @RequiresPermissions("manage:blogSort:list")
    @GetMapping("/list")
    public TableDataInfo list(BlogSort blogSort)
    {
        startPage();
        List<BlogSort> list = blogSortService.selectBlogSortList(blogSort);
        return getDataTable(list);
    }

    /**
     * 导出博客分类列表
     */
    @RequiresPermissions("manage:blogSort:export")
    @Log(title = "博客分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogSort blogSort)
    {
        List<BlogSort> list = blogSortService.selectBlogSortList(blogSort);
        ExcelUtil<BlogSort> util = new ExcelUtil<BlogSort>(BlogSort.class);
        util.exportExcel(response, list, "博客分类数据");
    }

    /**
     * 获取博客分类详细信息
     */
    @RequiresPermissions("manage:blogSort:query")
    @GetMapping(value = "/{uid}")
    public AjaxResult getInfo(@PathVariable("uid") String uid)
    {
        return AjaxResult.success(blogSortService.selectBlogSortByUid(uid));
    }

    /**
     * 新增博客分类
     */
    @RequiresPermissions("manage:blogSort:add")
    @Log(title = "博客分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogSort blogSort)
    {
        return toAjax(blogSortService.insertBlogSort(blogSort));
    }

    /**
     * 修改博客分类
     */
    @RequiresPermissions("manage:blogSort:edit")
    @Log(title = "博客分类", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody BlogSort blogSort)
    {
        return toAjax(blogSortService.updateBlogSort(blogSort));
    }

    /*
    * 博客分类状态修改
    * @author ytw杨
    * @date 9/4/2022 下午11:47
    * @param [blogSort]
     *@return com.blog.common.core.web.domain.AjaxResult
    */
    @RequiresPermissions("manage:blogSort:changeStatus")
    @Log(title = "博客分类", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody BlogSort blogSort){
       return toAjax(blogSortService.updateBlogSortStatus(blogSort));
    }
    /**
     * 删除博客分类
     */
    @RequiresPermissions("manage:blogSort:remove")
    @Log(title = "博客分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{uids}")
    public AjaxResult remove(@PathVariable String[] uids)
    {
        return toAjax(blogSortService.deleteBlogSortByUids(uids));
    }
}
