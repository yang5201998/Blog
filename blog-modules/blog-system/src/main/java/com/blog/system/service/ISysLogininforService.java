package com.blog.system.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.system.api.domain.SysLogininfor;

/**
 * 系统访问日志情况信息 服务层
 *
 * @author manage
 */
public interface ISysLogininforService extends IService<SysLogininfor>
{
    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    public int insertLogininfor(SysLogininfor logininfor);

    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * 查询系统登录日志当日ip总数
     *
     * @return 登录记录当日总数
     */
    public Long selectLogininforIpCount(LocalDate localDate);

    /**
     * 查询系统登录日志当日访问总量
     *
     * @return 登录记录当日总数
     */
    public Long selectLogininforCount(LocalDate tenDaysAgo);
    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * 清空系统登录日志
     */
    public void cleanLogininfor();

}
