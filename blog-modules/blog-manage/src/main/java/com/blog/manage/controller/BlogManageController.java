package com.blog.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.blog.manage.service.BlogManageService;
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
import com.blog.manage.domain.BlogManage;
import com.blog.common.core.web.controller.BaseController;
import com.blog.common.core.web.domain.AjaxResult;
import com.blog.common.core.utils.poi.ExcelUtil;
import com.blog.common.core.web.page.TableDataInfo;

/**
 * 博客管理Controller
 *
 * @author ytw杨
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/blogManage")
public class BlogManageController extends BaseController
{
    @Autowired
    private BlogManageService blogManageService;

    /**
     * 查询博客管理列表
     */
    @RequiresPermissions("manage:blogManage:list")
    @GetMapping("/list")
    public TableDataInfo list(BlogManage blogManage)
    {
        startPage();
        List<BlogManage> list = blogManageService.selectBlogManageList(blogManage);
        return getDataTable(list);
    }

    /**
     * 导出博客管理列表
     */
    @RequiresPermissions("manage:blogManage:export")
    @Log(title = "博客管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogManage blogManage)
    {
        List<BlogManage> list = blogManageService.selectBlogManageList(blogManage);
        ExcelUtil<BlogManage> util = new ExcelUtil<BlogManage>(BlogManage.class);
        util.exportExcel(response, list, "博客管理数据");
    }

    /**
     * 获取博客管理详细信息
     */
    @RequiresPermissions("manage:blogManage:query")
    @GetMapping(value = "/{uid}")
    public AjaxResult getInfo(@PathVariable("uid") String uid)
    {
        return AjaxResult.success(blogManageService.selectBlogManageByUid(uid));
    }

    /**
     * 新增博客管理
     */
    @RequiresPermissions("manage:blogManage:add")
    @Log(title = "博客管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogManage blogManage)
    {
        return toAjax(blogManageService.insertBlogManage(blogManage));
    }

    /**
     * 修改博客管理
     */
    @RequiresPermissions("manage:blogManage:edit")
    @Log(title = "博客管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogManage blogManage)
    {
        return toAjax(blogManageService.updateBlogManage(blogManage));
    }

    /**
     * 删除博客管理
     */
    @RequiresPermissions("manage:blogManage:remove")
    @Log(title = "博客管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{uids}")
    public AjaxResult remove(@PathVariable String[] uids)
    {
        return toAjax(blogManageService.deleteBlogManageByUids(uids));
    }
}
