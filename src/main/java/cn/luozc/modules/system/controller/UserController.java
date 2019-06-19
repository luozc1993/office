package cn.luozc.modules.system.controller;

import cn.luozc.common.utils.JsonData;
import cn.luozc.common.utils.MD5Util;
import cn.luozc.common.utils.TokenUtil;
import cn.luozc.modules.system.model.SysUser;
import cn.luozc.modules.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/login")
    @ResponseBody
    public JsonData login(String username,String password,HttpServletRequest request){
        String sign = TokenUtil.sign(username, "123");
        if(sign==null){
            return JsonData.fail("登录失败");
        }
        return JsonData.success(sign);
    }

    /**
     *  创建用户
     * @param user      用户信息
     * @param roleId    关联的角色id
     * @return          JsonData
     */
    @RequestMapping("/createUser")
    @ResponseBody
    public JsonData createUser(SysUser user, String roleId){
        //默认密码123456
        user.setPassword(MD5Util.getMD5Str("123456"));
        //添加用户
        user = userService.insert(user);
        return JsonData.success(user);
    }
}
