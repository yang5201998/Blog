package com.blog.system.domain;

import lombok.Data;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-04-02-17:58
 */
@Data
public class SysIndexVisitByWeek {

    //最近一周的日期
    private List weekdays;

    //访问量
    private List pv;

    //独立用户
    private List uv;
}
