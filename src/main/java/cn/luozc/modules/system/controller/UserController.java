package cn.luozc.modules.system.controller;

import cn.luozc.common.utils.JsonData;
import cn.luozc.common.utils.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/system/user")
public class UserController {


    @RequestMapping("/login")
    public JsonData login(String username,String password,HttpServletRequest request){
        String sign = TokenUtil.sign(username, "123");
        if(sign==null){
            return JsonData.fail("登录失败");
        }
        return JsonData.success(sign);
    }
}
