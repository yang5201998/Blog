package com.blog.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.common.core.constant.CacheConstants;
import com.blog.common.core.constant.DateForEachConstants;
import com.blog.common.core.utils.StringUtils;
import com.blog.common.core.web.domain.AjaxResult;
import com.blog.common.redis.service.RedisService;
import com.blog.common.security.annotation.RequiresPermissions;
import com.blog.manage.domain.BlogManage;
import com.blog.manage.mapper.BlogSortMapper;
import com.blog.system.api.BlogTagService;
import com.blog.manage.domain.BlogSort;
import com.blog.manage.domain.BlogTag;
import com.blog.manage.mapper.BlogManageMapper;
import com.blog.manage.mapper.BlogTagMapper;

import com.blog.system.api.BlogSortService;
import com.blog.system.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
    @Autowired
    private BlogManageMapper blogManageMapper;
    @Autowired
    private BlogSortService blogSortService;
    @Autowired
    private BlogSortMapper blogSortMapper;
    @Autowired
    private BlogTagService blogTagService;
    @Autowired
    private BlogTagMapper blogTagMapper;

    /**
    * 首页初始化参数
    * @author ytw杨
    * @date 25/4/2022 下午12:51
    * @param
    * @return com.blog.common.core.web.domain.AjaxResult
    */
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
        Integer integer = blogManageMapper.selectCount(new QueryWrapper<BlogManage>());
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("visitAddTotal",aLong);
        map.put("blogCount",integer);
        map.put("commentCount",0);
        map.put("userCount",keys.size());
        return AjaxResult.success(map);
    }
    /**
    *
    * @author ytw杨
    * @date 25/4/2022 下午7:05
    * @param
    * @return com.blog.common.core.web.domain.AjaxResult
    */
    @RequiresPermissions("system:index:blogContributeCount")
    @GetMapping("/blogContributeCount")
    public AjaxResult getBlogContributeCount(){
        //var contributeDate = ["2021-03-30 22:48:19","2022-03-30 22:48:19"];
        ConcurrentHashMap<String,Object> concurrentHashMap=new ConcurrentHashMap<>();
        List<String> contributeDate=new ArrayList();
        List<List> blogContributeCounts=new ArrayList();
        //获取当前日期与上一年日期
        LocalDateTime localDate = LocalDateTime.now();
        //获取上一年日期
        LocalDateTime lastLocalDateTime = localDate.plusYears(-1);
        String lastDate = lastLocalDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        contributeDate.add(lastDate);
        //获取当前日期
        String nowDate = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        contributeDate.add(nowDate);
       // var blogContributeCount = [["2021-03-30",0.0],["2021-03-31",0.0],["2021-04-01",0.0],["2021-04-02",0.0],["2021-04-03",0.0],["2021-04-04",0.0],["2021-04-05",0.0],["2021-04-06",0.0],["2021-04-07",0.0],["2021-04-08",0.0],["2021-04-09",0.0],["2021-04-10",0.0],["2021-04-11",0.0],["2021-04-12",0.0],["2021-04-13",0.0],["2021-04-14",0.0],["2021-04-15",0.0],["2021-04-16",0.0],["2021-04-17",0.0],["2021-04-18",0.0],["2021-04-19",0.0],["2021-04-20",0.0],["2021-04-21",0.0],["2021-04-22",0.0],["2021-04-23",0.0],["2021-04-24",0.0],["2021-04-25",0.0],["2021-04-26",0.0],["2021-04-27",0.0],["2021-04-28",0.0],["2021-04-29",0.0],["2021-04-30",0.0],["2021-05-01",0.0],["2021-05-02",0.0],["2021-05-03",0.0],["2021-05-04",0.0],["2021-05-05",0.0],["2021-05-06",0.0],["2021-05-07",0.0],["2021-05-08",0.0],["2021-05-09",0.0],["2021-05-10",0.0],["2021-05-11",0.0],["2021-05-12",0.0],["2021-05-13",0.0],["2021-05-14",0.0],["2021-05-15",0.0],["2021-05-16",0.0],["2021-05-17",0.0],["2021-05-18",0.0],["2021-05-19",0.0],["2021-05-20",0.0],["2021-05-21",0.0],["2021-05-22",0.0],["2021-05-23",0.0],["2021-05-24",0.0],["2021-05-25",0.0],["2021-05-26",0.0],["2021-05-27",0.0],["2021-05-28",0.0],["2021-05-29",0.0],["2021-05-30",0.0],["2021-05-31",0.0],["2021-06-01",0.0],["2021-06-02",0.0],["2021-06-03",0.0],["2021-06-04",0.0],["2021-06-05",0.0],["2021-06-06",0.0],["2021-06-07",0.0],["2021-06-08",0.0],["2021-06-09",0.0],["2021-06-10",0.0],["2021-06-11",0.0],["2021-06-12",0.0],["2021-06-13",0.0],["2021-06-14",0.0],["2021-06-15",0.0],["2021-06-16",0.0],["2021-06-17",0.0],["2021-06-18",0.0],["2021-06-19",0.0],["2021-06-20",0.0],["2021-06-21",0.0],["2021-06-22",0.0],["2021-06-23",0.0],["2021-06-24",0.0],["2021-06-25",0.0],["2021-06-26",0.0],["2021-06-27",0.0],["2021-06-28",0.0],["2021-06-29",0.0],["2021-06-30",0.0],["2021-07-01",0.0],["2021-07-02",0.0],["2021-07-03",0.0],["2021-07-04",0.0],["2021-07-05",0.0],["2021-07-06",0.0],["2021-07-07",0.0],["2021-07-08",0.0],["2021-07-09",0.0],["2021-07-10",0.0],["2021-07-11",0.0],["2021-07-12",0.0],["2021-07-13",0.0],["2021-07-14",0.0],["2021-07-15",0.0],["2021-07-16",0.0],["2021-07-17",0.0],["2021-07-18",0.0],["2021-07-19",0.0],["2021-07-20",0.0],["2021-07-21",0.0],["2021-07-22",0.0],["2021-07-23",0.0],["2021-07-24",0.0],["2021-07-25",0.0],["2021-07-26",0.0],["2021-07-27",0.0],["2021-07-28",0.0],["2021-07-29",0.0],["2021-07-30",0.0],["2021-07-31",0.0],["2021-08-01",0.0],["2021-08-02",0.0],["2021-08-03",0.0],["2021-08-04",0.0],["2021-08-05",0.0],["2021-08-06",0.0],["2021-08-07",0.0],["2021-08-08",0.0],["2021-08-09",0.0],["2021-08-10",0.0],["2021-08-11",0.0],["2021-08-12",0.0],["2021-08-13",0.0],["2021-08-14",0.0],["2021-08-15",0.0],["2021-08-16",0.0],["2021-08-17",0.0],["2021-08-18",0.0],["2021-08-19",0.0],["2021-08-20",0.0],["2021-08-21",0.0],["2021-08-22",0.0],["2021-08-23",0.0],["2021-08-24",0.0],["2021-08-25",0.0],["2021-08-26",0.0],["2021-08-27",0.0],["2021-08-28",0.0],["2021-08-29",0.0],["2021-08-30",0.0],["2021-08-31",0.0],["2021-09-01",0.0],["2021-09-02",0.0],["2021-09-03",0.0],["2021-09-04",0.0],["2021-09-05",0.0],["2021-09-06",0.0],["2021-09-07",0.0],["2021-09-08",0.0],["2021-09-09",0.0],["2021-09-10",0.0],["2021-09-11",0.0],["2021-09-12",0.0],["2021-09-13",0.0],["2021-09-14",0.0],["2021-09-15",0.0],["2021-09-16",0.0],["2021-09-17",0.0],["2021-09-18",0.0],["2021-09-19",0.0],["2021-09-20",0.0],["2021-09-21",0.0],["2021-09-22",0.0],["2021-09-23",0.0],["2021-09-24",0.0],["2021-09-25",0.0],["2021-09-26",0.0],["2021-09-27",0.0],["2021-09-28",0.0],["2021-09-29",0.0],["2021-09-30",0.0],["2021-10-01",0.0],["2021-10-02",0.0],["2021-10-03",0.0],["2021-10-04",0.0],["2021-10-05",0.0],["2021-10-06",0.0],["2021-10-07",0.0],["2021-10-08",0.0],["2021-10-09",0.0],["2021-10-10",0.0],["2021-10-11",0.0],["2021-10-12",0.0],["2021-10-13",0.0],["2021-10-14",0.0],["2021-10-15",0.0],["2021-10-16",0.0],["2021-10-17",0.0],["2021-10-18",0.0],["2021-10-19",0.0],["2021-10-20",0.0],["2021-10-21",0.0],["2021-10-22",0.0],["2021-10-23",0.0],["2021-10-24",0.0],["2021-10-25",0.0],["2021-10-26",0.0],["2021-10-27",0.0],["2021-10-28",0.0],["2021-10-29",0.0],["2021-10-30",0.0],["2021-10-31",0.0],["2021-11-01",0.0],["2021-11-02",0.0],["2021-11-03",0.0],["2021-11-04",0.0],["2021-11-05",0.0],["2021-11-06",0.0],["2021-11-07",0.0],["2021-11-08",0.0],["2021-11-09",0.0],["2021-11-10",0.0],["2021-11-11",0.0],["2021-11-12",0.0],["2021-11-13",0.0],["2021-11-14",0.0],["2021-11-15",0.0],["2021-11-16",0.0],["2021-11-17",0.0],["2021-11-18",0.0],["2021-11-19",0.0],["2021-11-20",0.0],["2021-11-21",0.0],["2021-11-22",0.0],["2021-11-23",0.0],["2021-11-24",0.0],["2021-11-25",0.0],["2021-11-26",0.0],["2021-11-27",0.0],["2021-11-28",0.0],["2021-11-29",0.0],["2021-11-30",0.0],["2021-12-01",0.0],["2021-12-02",0.0],["2021-12-03",0.0],["2021-12-04",0.0],["2021-12-05",0.0],["2021-12-06",0.0],["2021-12-07",0.0],["2021-12-08",0.0],["2021-12-09",0.0],["2021-12-10",0.0],["2021-12-11",0.0],["2021-12-12",0.0],["2021-12-13",0.0],["2021-12-14",0.0],["2021-12-15",0.0],["2021-12-16",0.0],["2021-12-17",0.0],["2021-12-18",0.0],["2021-12-19",0.0],["2021-12-20",0.0],["2021-12-21",0.0],["2021-12-22",0.0],["2021-12-23",0.0],["2021-12-24",0.0],["2021-12-25",0.0],["2021-12-26",0.0],["2021-12-27",0.0],["2021-12-28",0.0],["2021-12-29",0.0],["2021-12-30",0.0],["2021-12-31",0.0],["2022-01-01",0.0],["2022-01-02",0.0],["2022-01-03",0.0],["2022-01-04",0.0],["2022-01-05",0.0],["2022-01-06",0.0],["2022-01-07",0.0],["2022-01-08",0.0],["2022-01-09",0.0],["2022-01-10",0.0],["2022-01-11",0.0],["2022-01-12",0.0],["2022-01-13",0.0],["2022-01-14",0.0],["2022-01-15",0.0],["2022-01-16",0.0],["2022-01-17",0.0],["2022-01-18",0.0],["2022-01-19",0.0],["2022-01-20",0.0],["2022-01-21",0.0],["2022-01-22",0.0],["2022-01-23",0.0],["2022-01-24",0.0],["2022-01-25",0.0],["2022-01-26",0.0],["2022-01-27",0.0],["2022-01-28",0.0],["2022-01-29",0.0],["2022-01-30",0.0],["2022-01-31",0.0],["2022-02-01",0.0],["2022-02-02",0.0],["2022-02-03",0.0],["2022-02-04",0.0],["2022-02-05",0.0],["2022-02-06",0.0],["2022-02-07",0.0],["2022-02-08",0.0],["2022-02-09",0.0],["2022-02-10",0.0],["2022-02-11",0.0],["2022-02-12",0.0],["2022-02-13",0.0],["2022-02-14",0.0],["2022-02-15",0.0],["2022-02-16",0.0],["2022-02-17",0.0],["2022-02-18",0.0],["2022-02-19",0.0],["2022-02-20",0.0],["2022-02-21",0.0],["2022-02-22",0.0],["2022-02-23",0.0],["2022-02-24",0.0],["2022-02-25",0.0],["2022-02-26",0.0],["2022-02-27",0.0],["2022-02-28",0.0],["2022-03-01",0.0],["2022-03-02",0.0],["2022-03-03",0.0],["2022-03-04",0.0],["2022-03-05",0.0],["2022-03-06",0.0],["2022-03-07",0.0],["2022-03-08",0.0],["2022-03-09",0.0],["2022-03-10",0.0],["2022-03-11",0.0],["2022-03-12",0.0],["2022-03-13",0.0],["2022-03-14",0.0],["2022-03-15",0.0],["2022-03-16",0.0],["2022-03-17",0.0],["2022-03-18",0.0],["2022-03-19",0.0],["2022-03-20",0.0],["2022-03-21",0.0],["2022-03-22",0.0],["2022-03-23",0.0],["2022-03-24",0.0],["2022-03-25",0.0],["2022-03-26",0.0],["2022-03-27",1.0],["2022-03-28",1.0],["2022-03-29",0.0],["2022-03-30",0.0]];
       // 获取全年日期以及博客新增数
        concurrentHashMap.put("contributeDate",contributeDate);
        ZoneId zoneId = ZoneId.systemDefault();
        List<BlogManage> blogManages = blogManageMapper.selectList(new QueryWrapper<>());
        int blogNum=0;
        for (int i = 0; i <= DateForEachConstants.YEARS; i++) {
            List blogContributeCount=new ArrayList();
            LocalDateTime localDateTimes = lastLocalDateTime.plusDays(i);
            Date minf = Date.from(localDateTimes.with(LocalTime.MIN).atZone(zoneId).toInstant());
            Date maxf = Date.from(localDateTimes.with(LocalTime.MAX).atZone(zoneId).toInstant());
            for (BlogManage blogManage:blogManages){
                if (minf.before(blogManage.getCreateTime()) && maxf.after(blogManage.getCreateTime())){
                    blogNum++;
                }
            }
            String lastDates = localDateTimes.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            blogContributeCount.add(lastDates);
            blogContributeCount.add(blogNum);
            blogNum=0;
            blogContributeCounts.add(blogContributeCount);
        }
        concurrentHashMap.put("blogContributeCount",blogContributeCounts);
        return AjaxResult.success(concurrentHashMap);
    }
    /**
    * 获取周访问量和独立用户
    * @author ytw杨
    * @date 25/4/2022 下午12:51
    * @param
    * @return com.blog.common.core.web.domain.AjaxResult
    */
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
        for (int i = 0; i < DateForEachConstants.WEEKDAYS; i++) {
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
    /**
    * 通过博客分类获取博客数目
    * @author ytw杨
    * @date 25/4/2022 下午12:51
    * @param
    * @return com.blog.common.core.web.domain.AjaxResult 
    */
    @RequiresPermissions("system:index:blogCountByBlogSort")
    @GetMapping("/blogCountByBlogSort")
    public AjaxResult getBlogCountByBlogSort(){
        ArrayList<Object> list = new ArrayList<>();
        List<BlogSort> blogSort= blogSortMapper.selectList(new QueryWrapper<BlogSort>().orderByDesc("sort_used"));
        if (StringUtils.isNotEmpty(blogSort)) {
            blogSort.stream().forEach(item->{
                ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
                concurrentHashMap.put("name",item.getBlogSortName());
                concurrentHashMap.put("value",item.getSortUsed());
                concurrentHashMap.put("blogSortUid",item.getUid());
                list.add(concurrentHashMap);
            });
        }
        return AjaxResult.success(list);
    }
     /**
     * 通过标签获取博客数目
     * @author ytw杨
     * @date 25/4/2022 下午12:52
     * @param
     * @return com.blog.common.core.web.domain.AjaxResult
     */
    @RequiresPermissions("system:index:blogCountByTag")
    @GetMapping("/blogCountByTag")
    public AjaxResult getBlogCountByTag(){
        ArrayList<Object> list = new ArrayList<>();
        List<BlogTag> blogTags = blogTagMapper.selectList(new QueryWrapper<BlogTag>());
        if (StringUtils.isNotEmpty(blogTags)) {
            blogTags.stream().forEach(item->{
                ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
                concurrentHashMap.put("name",item.getTagName());
                concurrentHashMap.put("value",item.getTagUsed());
                concurrentHashMap.put("blogTagUid",item.getUid());
                list.add(concurrentHashMap);
           });
       }
        return AjaxResult.success(list);
    }
}
