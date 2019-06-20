package cn.luozc.modules.system.dao;

import cn.luozc.modules.system.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> selectPage(Map map);
}