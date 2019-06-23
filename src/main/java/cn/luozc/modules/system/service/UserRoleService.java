package cn.luozc.modules.system.service;

import cn.luozc.modules.system.model.UserRole;

public interface UserRoleService {

    /**
     * 添加用户
     * @param userRole
     * @return
     */
    int insert(UserRole userRole);

    /**
     * 根据用户id删除用户好角色关联数据
     * @param uid
     * @return
     */
    int deleteByUid(String uid);

}
