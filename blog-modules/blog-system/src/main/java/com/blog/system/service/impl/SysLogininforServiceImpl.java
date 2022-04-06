package com.blog.system.service.impl;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.system.api.domain.SysLogininfor;
import com.blog.system.mapper.SysLogininforMapper;
import com.blog.system.service.ISysLogininforService;

/**
 * 系统访问日志情况信息 服务层处理
 *
 * @author manage
 */
@Service
public class SysLogininforServiceImpl extends ServiceImpl<SysLogininforMapper,SysLogininfor> implements ISysLogininforService
{

    @Autowired
    private SysLogininforMapper logininforMapper;

    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    @Override
    public int insertLogininfor(SysLogininfor logininfor)
    {
        return logininforMapper.insertLogininfor(logininfor);
    }

    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    @Override
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor)
    {
        return logininforMapper.selectLogininforList(logininfor);
    }
    /**
       * @Param: * @param
       * @Author: yangtingwei
       * @Date: 2022/3/31 11:48
       * @描述:  查询当日访问ip数
    */
    @Override
    public Long selectLogininforIpCount(LocalDate localDate) {
        Long aLong = logininforMapper.selectCountIpOne(localDate);
        return aLong;
    }
    /**
       * @Param: * @param tenDaysAgo
       * @Author: yangtingwei
       * @Date: 2022/4/6 10:46
       * @描述: 查询当日访问总量
    */
    @Override
    public Long selectLogininforCount(LocalDate tenDaysAgo) {
        Long aLong = logininforMapper.selectCountSum(tenDaysAgo);
        return aLong;
    }
    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    @Override
    public int deleteLogininforByIds(Long[] infoIds)
    {
        return logininforMapper.deleteLogininforByIds(infoIds);
    }

    /**
     * 清空系统登录日志
     */
    @Override
    public void cleanLogininfor()
    {
        logininforMapper.cleanLogininfor();
    }


}
