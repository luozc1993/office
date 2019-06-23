package cn.luozc.modules.common.service;

import cn.luozc.modules.system.model.Menu;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

    /**
     * @param map
     * @return
     */
    List<T> list(Map<String, Object> map);

    /**
     * 获取数据总数
     *
     * @param map
     * @return
     */
    int count(Map<String, Object> map);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 修改
     *
     * @param record
     * @return
     */
    int update(T record);

    /**
     * 刪除
     *
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 查询所有
     * @return
     */
    List<Menu> findAll();

}
