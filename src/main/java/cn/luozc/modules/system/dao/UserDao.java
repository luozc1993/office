package cn.luozc.modules.system.dao;

import cn.luozc.modules.system.model.User;

import java.util.List;

public interface UserDao {
    List<User> selectPage(int start,int end);
}