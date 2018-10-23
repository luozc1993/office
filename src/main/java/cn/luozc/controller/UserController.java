package cn.luozc.controller;

import cn.luozc.common.JsonData;
import cn.luozc.dao.CountryMapper;
import cn.luozc.model.SysUser;
import cn.luozc.param.SysLoginUserParam;
import cn.luozc.service.SqlService;
import cn.luozc.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SqlService sqlService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView page(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ModelAndView("user/login");
    }

    /**
     * 用户登录
     * @param param //参数
     * @param request   //
     * @param response  //
     * @return  //
     */
    @RequestMapping("/logins.json")
    @ResponseBody
    public JsonData logins(SysLoginUserParam param, HttpServletRequest request, HttpServletResponse response) {
        SysUser sysUser = sysUserService.logins (param);
        if(sysUser==null){
            return JsonData.fail ("账号或密码错误！");
        }
        //验证账号是否启用
        if(sysUser.getStatus ()==1){
            return JsonData.fail ("账号已被禁用请联系管理员！");
        }
        request.getSession().setAttribute("user", sysUser);
        return JsonData.success();
    }
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ModelAndView("user/login");
    }

    private ClassPathXmlApplicationContext context;

    @Resource
    private CountryMapper countryMapper;

    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        // 3. 执行sql语句 ( 使用fastjson转化为json格式 )
        List list = sqlService.select ("select * from sys_user");


        return list;
    }



}
