package cn.luozc.modules.system.service;

import cn.luozc.modules.system.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

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
     * 添加用户
     *
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 刪除用戶
     *
     * @param userId
     * @return
     */
    int delete(String userId);

    /**
     * 修改用户状态
     *
     * @param map
     * @return
     */
    int updateUserState(Map<String, Object> map);
}
