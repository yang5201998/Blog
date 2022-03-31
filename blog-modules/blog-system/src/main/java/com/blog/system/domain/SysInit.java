package com.blog.system.domain;

import lombok.Data;

/**
 * @author shkstart
 * @create 2022-03-31-10:25
 */
@Data
public class SysInit {
    //博客总数
    private Long blogCount;

    //评论数
    private Long commentCount;

    //当前在线用户数
    private Long userCount;

    //今日访问数
    private Long visitAddTotal;
}
