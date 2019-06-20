package cn.luozc.modules.system.controller;

import cn.luozc.common.utils.JsonData;
import cn.luozc.common.utils.MD5Util;
import cn.luozc.common.utils.TokenUtil;
import cn.luozc.modules.system.model.User;
import cn.luozc.modules.system.service.UserService;
import net.sf.json.JSONObject;
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
    public JsonData createUser(User user, String roleId){
        //默认密码123456
        user.setPassword(MD5Util.getMD5Str("123456"));
        return JsonData.success(user);
    }
    @RequestMapping("/userList")
    @ResponseBody
    public JSONObject userList(){
        JSONObject result = new JSONObject();

        result.put("code",0);
        result.put("msg","");
        result.put("count",0);
        result.put("data",userService.list());

        return result;
    }
}
