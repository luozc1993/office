package cn.luozc.controller;

import cn.luozc.common.JsonData;
import cn.luozc.model.SysMenu;
import cn.luozc.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sys/menu")
@Slf4j
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;


    @RequestMapping("/getMenuGroups.json")
    @ResponseBody
    public JsonData getMenuGroups(){
        List<SysMenu> menuGroups = sysMenuService.getMenuGroups ();
        return JsonData.success (menuGroups);
    }
    @RequestMapping("/getMenus.json")
    @ResponseBody
    public JsonData menus(){
        return JsonData.success (sysMenuService.getMenus ());
    }
}
