package cn.luozc.modules.system.service.impl;

import cn.luozc.modules.system.dao.UserRoleMapper;
import cn.luozc.modules.system.model.UserRole;
import cn.luozc.modules.system.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleServiceImpl  implements UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;

    public int insert(UserRole userRole){
        return  userRoleMapper.insert(userRole);
    }

    @Override
    public int deleteByUid(String uid) {
        return userRoleMapper.deleteByUid(uid);
    }

}
