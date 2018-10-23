package cn.luozc.dao;

import cn.luozc.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 通过账号查询用户信息
     * @param username
     * @return
     */
    SysUser findSysUserByUsername(String username);

    /**
     * 分页查询
     * @param start
     * @param size
     * @return
     */
    List<SysUser> findSysUserLimit(@Param ("start")int start, @Param ("size")int size);

    int count();
}