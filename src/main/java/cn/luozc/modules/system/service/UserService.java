package cn.luozc.modules.system.service;

import cn.luozc.modules.system.dao.SysUserDao;
import cn.luozc.modules.system.model.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private SysUserDao sysUserDao;

    public SysUser insert(SysUser sysUser){
        sysUserDao.insert(sysUser);
        return sysUser;
    }

    public List<SysUser> list(){
        return sysUserDao.selectPage(0,1);
    }
}
