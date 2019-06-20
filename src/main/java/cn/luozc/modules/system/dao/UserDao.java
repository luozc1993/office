package cn.luozc.modules.system.dao;

import cn.luozc.modules.system.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户管理
 */
public interface UserDao {
    /**
     * 分页查询
     * @param map
     * @return
     */
    List<User> selectPage(Map map);

    /**
     * 获取数据总量
     * @param map
     * @return
     */
    int count(Map map);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insertSelective(User record);
}