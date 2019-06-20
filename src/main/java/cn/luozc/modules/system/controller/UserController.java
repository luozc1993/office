package cn.luozc.modules.system.controller;

import cn.luozc.common.utils.JsonData;
import cn.luozc.common.utils.MD5Util;
import cn.luozc.common.utils.TokenUtil;
import cn.luozc.modules.system.model.User;
import cn.luozc.modules.system.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/login")
    @ResponseBody
    public JsonData login(String username, String password, HttpServletRequest request) {
        String sign = TokenUtil.sign(username, "123");
        if (sign == null) {
            return JsonData.fail("登录失败");
        }
        return JsonData.success(sign);
    }

    /**
     * 创建用户
     *
     * @param user   用户信息
     * @param roleId 关联的角色id
     * @return JsonData
     */
    @RequestMapping("/createUser")
    @ResponseBody
    public JsonData createUser(User user, String roleId) {
        //默认密码123456
        user.setPassword(MD5Util.getMD5Str("123456"));
        user.setId(MD5Util.getMD5Str(UUID.randomUUID().toString()));
        return JsonData.success(userService.insert(user));
    }

    /**
     * 修改用户
     *
     * @param user   用户信息
     * @param roleId 关联的角色id
     * @return JsonData
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public JsonData updateUser(User user, String roleId) {
        //默认密码123456
        return JsonData.success(userService.update(user));
    }

    /**
     * 用户列表
     *
     * @param page  页数
     * @param limit 每页显示数量
     * @return JSONObject
     */
    @RequestMapping("/userList")
    @ResponseBody
    public JSONObject userList(@RequestParam Map<String, Object> map, int page, int limit) {
        //加工查询参数
        map.put("start", (page - 1) * limit);
        map.put("end", page * limit);
        //返回值
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", userService.count(map));
        result.put("data", userService.list(map));

        return result;
    }

    /**
     * 刪除
     * @param userId
     * @return
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public JsonData deleteUser(String userId) {
        userService.delete(userId);
        return JsonData.success("","删除成功");
    }

    /**
     *
     * @return
     */
    @RequestMapping("/updateUserState")
    @ResponseBody
    public JsonData updateUserState(@RequestParam Map<String, Object> map){
        userService.updateUserState(map);

        return JsonData.success("","修改成功");
    }

}
