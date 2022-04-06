package com.blog.system.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.system.api.domain.SysLogininfor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 系统访问日志情况信息 数据层
 *
 * @author manage
 */
@Mapper
public interface SysLogininforMapper extends BaseMapper<SysLogininfor>
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
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * 清空系统登录日志
     *
     * @return 结果
     */
    public int cleanLogininfor();
/**
   * @Param: * @param localDate
   * @Author: yangtingwei
   * @Date: 2022/4/6 10:41
   * @描述: 获取每日ip数
*/
    Long selectCountIpOne(LocalDate localDate);
    /**
     * @Param: * @param localDate
     * @Author: yangtingwei
     * @Date: 2022/4/6 10:41
     * @描述: 获取每日访问总量
     */
    Long selectCountSum(LocalDate tenDaysAgo);
}
