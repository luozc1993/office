package cn.luozc.modules.system.service.impl;

import cn.luozc.modules.system.dao.IUserDao;
import cn.luozc.modules.system.model.User;
import cn.luozc.modules.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private IUserDao IUserDao;

    /**
     * @param map
     * @return
     */
    public List<User> list(Map<String, Object> map) {

        return IUserDao.selectPage(map);
    }

    public int count(Map<String, Object> map) {

        return IUserDao.count(map);
    }

    public int insert(User user) {
        return IUserDao.insertSelective(user);
    }

    @Override
    public int update(User user) {
        return IUserDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(String userId) {
        return IUserDao.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateUserState(Map<String, Object> map) {
        return IUserDao.updateUserState(map);
    }
}
