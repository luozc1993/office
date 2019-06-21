package cn.luozc.modules.system.service.impl;

import cn.luozc.modules.system.dao.RoleMapper;
import cn.luozc.modules.system.dao.UserRoleMapper;
import cn.luozc.modules.system.model.Role;
import cn.luozc.modules.system.model.User;
import cn.luozc.modules.system.model.UserRole;
import cn.luozc.modules.system.service.RoleService;
import cn.luozc.modules.system.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService{

}
