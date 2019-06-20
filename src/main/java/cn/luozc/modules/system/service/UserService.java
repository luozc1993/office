package cn.luozc.modules.system.service;

import cn.luozc.modules.system.dao.UserDao;
import cn.luozc.modules.system.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Resource
    private UserDao userDao;


    public List<User> list(Map<String,Object> map){

        return userDao.selectPage(map);
    }

    public int count(Map<String,Object> map){

        return userDao.count(map);
    }

    public int insert(User user){
        return userDao.insertSelective(user);
    }
}
