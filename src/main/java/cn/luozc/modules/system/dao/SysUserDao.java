package cn.luozc.modules.system.dao;

import cn.luozc.modules.system.model.SysUser;

import java.util.List;

public interface SysUserDao {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> selectPage(int start,int end);
}