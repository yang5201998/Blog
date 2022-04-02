package com.blog.system.controller;

import com.blog.common.core.constant.CacheConstants;
import com.blog.common.core.web.domain.AjaxResult;
import com.blog.common.redis.service.RedisService;
import com.blog.common.security.annotation.RequiresPermissions;
import com.blog.system.domain.SysIndexInit;
import com.blog.system.domain.SysIndexVisitByWeek;
import com.blog.system.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    public AjaxResult getinit(){
        //获取 ip访问数
        Long aLong = logininforService.selectLogininforCount();
        SysIndexInit sysIndexInit = new SysIndexInit();
        //获取当前用户数
        Collection<String> keys = redisService.keys(CacheConstants.LOGIN_TOKEN_KEY + "*");
        int size = keys.size();
        sysIndexInit.setVisitAddTotal(aLong);
        sysIndexInit.setUserCount(Long.valueOf(size));
        sysIndexInit.setBlogCount(0L);
        sysIndexInit.setCommentCount(0L);
        return AjaxResult.success(sysIndexInit);
    }

    @RequiresPermissions("system:index:visitByWeek")
    @GetMapping("/visitByWeek")
    public AjaxResult getVisitByWeek(){
        SysIndexVisitByWeek sysIndexVisitByWeek = new SysIndexVisitByWeek();
//        Double pv[]=new Double[]{65.0,119.0,127.0,105.0,107.0,108.0,69.0};
//        Double uv[]=new Double[]{420.0,666.0,723.0,654.0,524.0,547.0,407.0};
        ArrayList weekdays=new ArrayList();
        ArrayList pv=new ArrayList();
        ArrayList uv=new ArrayList();
        //获取当前日期
        LocalDate now = LocalDate.now();
        for (int i = 1; i <= 7; i++) {
            LocalDate tenDaysAgo = now.plusDays(-i);
            weekdays.add(tenDaysAgo);
        }
        //获取 ip访问数
        Long aLong = logininforService.selectLogininforCount();

        sysIndexVisitByWeek.setWeekdays(weekdays);
        sysIndexVisitByWeek.setPv(pv);
        sysIndexVisitByWeek.setUv(uv);
        return AjaxResult.success(sysIndexVisitByWeek);
    }
}
