package cn.luozc.service;

import cn.luozc.dao.SysMenuMapper;
import cn.luozc.model.SysMenu;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    public List<SysMenu> getMenuGroups(){
       return sysMenuMapper.findMenuGroups ();
    }
    public JSONObject getMenus(){
        //菜单组
        List<SysMenu> menuGroups = sysMenuMapper.findMenuGroups ();
        //菜单
        List<SysMenu> menus = sysMenuMapper.findMenus ();
        //要返回的数据
        JSONObject json = new JSONObject ();
        //遍历菜单组和菜单，先将菜单按菜单组分好放进json中
        for (SysMenu group:menuGroups){
            //组id
            int gid = group.getId ();
            List<SysMenu> list = new ArrayList<> ();
            for (SysMenu menu:menus){
                if(menu.getGroupid ()==gid){
                    list.add (menu);
                }
            }
            json.accumulate (gid+"",machiningMenu(list));
        }
        return json;
    }

    public List<JSONObject>  machiningMenu(List<SysMenu> menus){
        List<JSONObject> list = new ArrayList<>();
        for (SysMenu menu : menus){
            if(menu.getUpperId ()==0){
                JSONObject json = JSONObject.fromObject (menu);
                List<JSONObject> l = recursionMenu(menus,menu.getId ());
                if(l.size ()>0){
                    json.accumulate ("children",l);
                }
                list.add (json);
            }
        }


        return list;
    }

    public List<JSONObject> recursionMenu(List<SysMenu> menus,int upperId){
        List<JSONObject> list = new ArrayList<> ();
        for (SysMenu menu:menus){
            if(menu.getUpperId ()==upperId){
                JSONObject json = JSONObject.fromObject (menu);
                List<JSONObject> l = recursionMenu(menus,menu.getId ());
                if(l.size ()>0){
                    json.accumulate ("children",l);
                }
                list.add (json);
            }
        }


        return list;
    }
}
