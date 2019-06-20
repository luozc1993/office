package cn.luozc.modules.system.service;

import cn.luozc.modules.system.model.Role;
import cn.luozc.modules.system.model.User;

import java.util.List;
import java.util.Map;

public interface RoleService {

    /**
     * @param map
     * @return
     */
    List<User> list(Map<String, Object> map);

    /**
     * 获取数据总数
     *
     * @param map
     * @return
     */
    int count(Map<String, Object> map);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insert(Role record);

    /**
     * 修改
     *
     * @param record
     * @return
     */
    int update(Role record);

    /**
     * 刪除
     *
     * @param id
     * @return
     */
    int delete(String id);

}
