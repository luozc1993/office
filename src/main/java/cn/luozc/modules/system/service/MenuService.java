package cn.luozc.modules.system.service;

import cn.luozc.modules.common.service.BaseService;
import cn.luozc.modules.system.model.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService extends BaseService<Menu> {


    List<Map> menuTreeData();



}
