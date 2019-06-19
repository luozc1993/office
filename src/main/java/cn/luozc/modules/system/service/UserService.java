package cn.luozc.modules.system.service;

import cn.luozc.modules.system.dao.SysUserMapper;
import cn.luozc.modules.system.model.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private SysUserMapper sysUserMapper;

    public SysUser insert(SysUser sysUser){
        sysUserMapper.insert(sysUser);
        return sysUser;
    }
}
