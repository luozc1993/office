package cn.luozc.modules.system.dao;


import cn.luozc.modules.system.model.Role;
import cn.luozc.modules.system.model.User;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    /**
     * 通过id删除数据
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入数据
     *
     * @param record
     * @return
     */
    int insertSelective(Role record);

    /**
     * 通过id查询信息
     *
     * @param id
     * @return
     */
    Role selectByPrimaryKey(String id);

    /**
     * 修改数据
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Role record);


    /**
     * 分页查询
     *
     * @param map
     * @return
     */
    List<User> selectPage(Map map);

    /**
     * 获取数据总量
     *
     * @param map
     * @return
     */
    int count(Map map);
}