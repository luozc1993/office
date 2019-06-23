package cn.luozc.modules.system.dao;

import cn.luozc.modules.system.model.Menu;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    int deleteByPrimaryKey(String mid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String mid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> findAll();

    List<Map> menuTreeData();

}