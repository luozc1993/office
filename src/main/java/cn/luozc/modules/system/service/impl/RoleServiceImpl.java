package cn.luozc.modules.system.service.impl;

import cn.luozc.modules.system.dao.RoleMapper;
import cn.luozc.modules.system.model.Role;
import cn.luozc.modules.system.model.User;
import cn.luozc.modules.system.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper iRoleDao;

    @Override
    public List<User> list(Map<String, Object> map) {
        return iRoleDao.selectPage(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return iRoleDao.count(map);
    }

    @Override
    public int insert(Role record) {
        return iRoleDao.insertSelective(record);
    }

    @Override
    public int update(Role record) {
        return iRoleDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(String id) {
        return iRoleDao.deleteByPrimaryKey(id);
    }
}
