package cn.luozc.controller;

import cn.luozc.common.JsonData;
import cn.luozc.param.SysUserParam;
import cn.luozc.service.SqlService;
import cn.luozc.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/sys/user")
@Slf4j
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SqlService sqlService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/userList")
    public ModelAndView user() {
        return new ModelAndView("sys/user/userList");
    }

    /**
     * 获取用户列表
     * @param page  页数
     * @param limit 每页显示的数量
     * @return  //
     */
    @RequestMapping("/getUserList.json")
    @ResponseBody
    public Object getUserList(int page,int limit){
        JSONObject json = new JSONObject ();
        json.accumulate ("code",0);
        json.accumulate ("msg","");
        json.accumulate ("count",sysUserService.count ());
        json.accumulate ("data",sysUserService.getUserListLimit ((page - 1) * limit, limit));
        return json;
    }

    /**
     * 修改用户状态
     * @param status    用状态0启用  1禁用
     * @param uid       需要禁用的用户id
     * @return  //
     */
    @RequestMapping("/setUserStatus")
    @ResponseBody
    public JsonData setUserStatus(int status,int uid){
        sqlService.update ("update sys_user set status="+status+" where id="+uid);
        return JsonData.success ();
    }

    /**
     * 删除用户
     * @param   uid //需要删除的用户id
     * @return  //
     */
    @RequestMapping("/delUser")
    @ResponseBody
    public JsonData delUser(int uid){
        sqlService.delete ("delete from sys_user where id="+uid);
        return JsonData.success ();
    }
    /**
     * 删除用户
     * @param   uid //需要删除的用户id
     * @return  //
     */
    @RequestMapping("/delUsers")
    @ResponseBody
    public JsonData delUsers(String ids){
        String[] arr = ids.split (",");
        for(String uid : arr){
            sqlService.delete ("delete from sys_user where id="+uid);
        }

        return JsonData.success ();
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public JsonData addUser(SysUserParam param, HttpSession session){
        return sysUserService.addUser (param,session);
    }
}
