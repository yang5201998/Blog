package com.blog.system.api;

import com.blog.common.core.constant.ServiceNameConstants;
import com.blog.common.core.domain.R;
import com.blog.system.api.factory.RemoteLogFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author ytw杨
 * @date 2022年04月24日 下午11:38
 */
@FeignClient(contextId = "blogTagService", value = ServiceNameConstants.MANAGE_SERVICE, fallbackFactory = RemoteLogFallbackFactory.class)
public interface BlogTagService {
    /**
     * 查询博客标签列表
     *
     * @param blogTag 博客标签
     * @return 博客标签集合
     */
//    @PostMapping("/blogTag/list")
//    public R<List<BlogTag>> selectBlogTagList(@RequestBody BlogTag blogTag);
}
