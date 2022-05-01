package com.blog.system.api;

import com.blog.common.core.constant.ServiceNameConstants;
import com.blog.common.core.domain.R;

import com.blog.system.api.factory.RemoteLogFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(contextId = "blogSortService", value = ServiceNameConstants.MANAGE_SERVICE, fallbackFactory = RemoteLogFallbackFactory.class)
public interface BlogSortService {
    /**
     * 查询博客分类列表
     *
     * @param blogSort 博客分类
     * @return 博客分类集合
     */
//    @PostMapping("/blogSort/list")
//    public R<List<BlogSort>> selectBlogSortList(@RequestBody BlogSort blogSort);
}
