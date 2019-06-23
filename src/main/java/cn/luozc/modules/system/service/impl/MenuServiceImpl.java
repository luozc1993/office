package cn.luozc.modules.system.service.impl;

import cn.luozc.modules.system.dao.MenuMapper;
import cn.luozc.modules.system.model.Menu;
import cn.luozc.modules.system.model.Role;
import cn.luozc.modules.system.model.User;
import cn.luozc.modules.system.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> list(Map<String, Object> map) {
        return null;
    }

    @Override
    public int count(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public int update(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(String id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Menu> findAll() {
        return menuMapper.findAll();
    }

    @Override
    public List<Map> menuTreeData() {
        return menuMapper.menuTreeData();
    }
}
