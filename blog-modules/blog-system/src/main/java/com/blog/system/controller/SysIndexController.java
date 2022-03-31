package com.blog.system.controller;

import com.blog.common.core.constant.CacheConstants;
import com.blog.common.core.domain.R;
import com.blog.common.redis.service.RedisService;
import com.blog.common.security.annotation.RequiresPermissions;
import com.blog.system.domain.SysInit;
import com.blog.system.service.ISysLogininforService;
import com.blog.system.service.SysIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author shkstart
 * @create 2022-03-31-10:07
 */
@RestController
@RequestMapping("/index")
public class SysIndexController {
    @Autowired
    private ISysLogininforService logininforService;
    @Autowired
    private RedisService redisService;

    @RequiresPermissions("system:index:init")
    @GetMapping("/init")
    public R getinit(){
        //获取 ip访问数
        Long aLong = logininforService.selectLogininforCount();
        SysInit sysInit = new SysInit();
        //获取当前用户数
        Collection<String> keys = redisService.keys(CacheConstants.LOGIN_TOKEN_KEY + "*");
        int size = keys.size();
        sysInit.setVisitAddTotal(aLong);
        sysInit.setUserCount(Long.valueOf(size));
        sysInit.setBlogCount(0L);
        sysInit.setCommentCount(0L);
        return R.ok(sysInit);
    }
}
