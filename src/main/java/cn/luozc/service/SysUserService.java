package cn.luozc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.luozc.common.JsonData;
import cn.luozc.dao.ISqlDao;
import cn.luozc.model.Sql;
import cn.luozc.param.SysUserParam;
import org.springframework.stereotype.Service;

import cn.luozc.dao.SysUserMapper;
import cn.luozc.model.SysUser;
import cn.luozc.param.SysLoginUserParam;
import cn.luozc.util.BeanValidator;
import cn.luozc.util.MD5Util;

@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private ISqlDao sqlDao;

    @Resource
    private SqlService sqlService;

    /**
     * 登录验证
     * @param param //
     * @return  //
     */
    public SysUser logins(SysLoginUserParam param){
        //验证数据
        BeanValidator.check(param);
        //获取账号
        String username = param.getUsername ();
        //通过账号查询
        SysUser sysUser = sysUserMapper.findSysUserByUsername (username);
        //获取用户输入的账号
        String password = param.getPassword ();
        //获取数据库存储的密码
        String dbPassword = sysUser.getPassword ();
        //验证密码是否正确
        if(!dbPassword.equals (MD5Util.encrypt (password))){
            return null;
        }


        return  sysUser;
    }

    /**
     * 获取用户分页数据
     * @param start //起始下标
     * @param size  //每页显示数量
     * @return  //
     */
    public List<SysUser> getUserListLimit(int start, int size){
        return sysUserMapper.findSysUserLimit (start,size);
    }

    /**
     * 获取用户总数
     * @return //
     */
    public int count(){
        return sysUserMapper.count ();
    }

    public JsonData addUser(SysUserParam param, HttpSession session){
        Map<String,String> map = new HashMap<> ();
        String phone = param.getTelPhone ();




        map.put ("telephone",param.getTelPhone ());
        map.put ("sex",param.getUserSex ());
        map.put ("status",param.getUserStatus ()+"");
        map.put ("remark",param.getUserDesc ());
        if(param.getId ()!=null&&param.getId ()>0){
            Map<String,String> whereMap = new HashMap<> ();
            whereMap.put ("id",param.getId ()+"");
            int i1 = sqlService.updateMap ("sys_user", map, whereMap);
            if(i1<=0)return JsonData.fail ("修改失败");
        }else{
            int j = sqlDao.selectCount (new Sql ("select count(*) from sys_user where username='"+param.getUserName ()+"'"));
            if(j>0)return JsonData.fail ("账号已存在");
            int i = sqlDao.selectCount (new Sql ("select count(*) from sys_user where telephone='"+phone+"'"));
            if(i>0)return JsonData.fail ("手机号已存在");

            map.put ("username",param.getUserName ());
            map.put ("password",MD5Util.encrypt ("123456"));
            int i1 = sqlService.insertMap ("sys_user", map);
            if(i1<=0)return JsonData.fail ("添加失败");
        }

        return JsonData.success ();
    }
}
