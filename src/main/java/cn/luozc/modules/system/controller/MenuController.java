package cn.luozc.modules.system.controller;

import cn.luozc.common.utils.JsonData;
import cn.luozc.common.utils.MD5Util;
import cn.luozc.modules.system.model.Menu;
import cn.luozc.modules.system.service.MenuService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/system/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 创建
     *
     * @return JsonData
     */
    @RequestMapping("/create")
    @ResponseBody
    public JsonData create(Menu menu) {
        menu.setMid(MD5Util.getMD5Str(UUID.randomUUID().toString()));
        menu.setCreatetime(new Date());
        menu.setUpdatetime(new Date());
        return JsonData.success(menuService.insert(menu));
    }

    /**
     * 修改
     *
     * @return JsonData
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonData update(Menu menu) {
        menu.setUpdatetime(new Date());
        return JsonData.success(menuService.update(menu),"修改成功");
    }


    /**
     * 刪除
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonData delete(String id) {
        menuService.delete(id);
        return JsonData.success("","删除成功");
    }

    /**
     * 刪除
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public JSONObject list() {
        List<Menu> list = menuService.findAll();

        //返回值
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",list.size());
        result.put("data", list);
        return result;
    }
    @RequestMapping("/menuTreeData")
    @ResponseBody
    public JsonData menuTreeData(){
        return JsonData.success(menuService.menuTreeData(),"");
    }
}
