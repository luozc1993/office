package cn.luozc.modules.system.dao;

import cn.luozc.modules.system.model.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    /**
     * 根据uid删除用户角色关联数据
     * @param uid
     * @return
     */
    int deleteByUid(@Param("uid")String uid);
}