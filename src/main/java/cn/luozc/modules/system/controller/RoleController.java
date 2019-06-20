package cn.luozc.modules.system.controller;

import cn.luozc.common.utils.JsonData;
import cn.luozc.common.utils.MD5Util;
import cn.luozc.common.utils.TokenUtil;
import cn.luozc.modules.system.model.Role;
import cn.luozc.modules.system.model.User;
import cn.luozc.modules.system.service.RoleService;
import cn.luozc.modules.system.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/system/role")
public class RoleController {

    @Resource
    private RoleService roleService;


    /**
     * 创建
     *
     * @return JsonData
     */
    @RequestMapping("/create")
    @ResponseBody
    public JsonData create(Role role) {
        role.setId(MD5Util.getMD5Str(UUID.randomUUID().toString()));
        return JsonData.success(roleService.insert(role));
    }

    /**
     * 修改
     *
     * @return JsonData
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonData update(Role role) {
        return JsonData.success(roleService.update(role));
    }

    /**
     * 用户列表
     *
     * @param page  页数
     * @param limit 每页显示数量
     * @return JSONObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JSONObject list(@RequestParam Map<String, Object> map, int page, int limit) {
        //加工查询参数
        map.put("start", (page - 1) * limit);
        map.put("end", page * limit);
        //返回值
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", roleService.count(map));
        result.put("data", roleService.list(map));

        return result;
    }

    /**
     * 刪除
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonData delete(String id) {
        roleService.delete(id);
        return JsonData.success("","删除成功");
    }



}
