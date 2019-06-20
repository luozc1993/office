package cn.luozc.modules.system.service;

import cn.luozc.modules.system.dao.UserDao;
import cn.luozc.modules.system.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;


    public List<User> list(){
        return userDao.selectPage(0,1);
    }
}
