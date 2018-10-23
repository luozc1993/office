package cn.luozc.dao;

import cn.luozc.model.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    /**
     * 获取菜单组数据
     * @return
     */
    List<SysMenu> findMenuGroups();

    /**
     * 获取菜单
     * @return
     */
    List<SysMenu> findMenus();

    /**
     * 获取所有菜单
     * @return
     */
    List<SysMenu> findMenuAll();
}