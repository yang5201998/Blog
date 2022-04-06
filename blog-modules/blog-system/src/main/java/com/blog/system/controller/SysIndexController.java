package com.blog.system.controller;

import com.blog.common.core.constant.CacheConstants;
import com.blog.common.core.web.domain.AjaxResult;
import com.blog.common.redis.service.RedisService;
import com.blog.common.security.annotation.RequiresPermissions;
import com.blog.system.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
        //获取当前日期
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(0);
        //获取 ip访问数
        Long aLong = logininforService.selectLogininforIpCount(localDate);
        //获取当前用户数
        Collection<String> keys = redisService.keys(CacheConstants.LOGIN_TOKEN_KEY + "*");
        int size = keys.size();
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("visitAddTotal",aLong);
        map.put("blogCount",0);
        map.put("commentCount",0);
        map.put("userCount",size);
        return AjaxResult.success(map);
    }

    @RequiresPermissions("system:index:visitByWeek")
    @GetMapping("/visitByWeek")
    public AjaxResult getVisitByWeek(){
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        ArrayList weekdays=new ArrayList();
        ArrayList pv=new ArrayList();
        ArrayList uv=new ArrayList();
        Long ipCount = null;
        Long ipSum=null;
        //获取当前日期
        LocalDate now = LocalDate.now();
        for (int i = 0; i < 7; i++) {
            //获取最近7天的日期
            LocalDate tenDaysAgo = now.plusDays(i-6);
            weekdays.add(tenDaysAgo);
            //获取每日ip访问数
            ipCount = logininforService.selectLogininforIpCount(tenDaysAgo);
            pv.add(ipCount);
            //获取当日系统访问量
            ipSum= logininforService.selectLogininforCount(tenDaysAgo);
            uv.add(ipSum);

        }
        concurrentHashMap.put("weekdays",weekdays);
        concurrentHashMap.put("pv",pv);
        concurrentHashMap.put("uv",uv);
        return AjaxResult.success(concurrentHashMap);
    }
}
