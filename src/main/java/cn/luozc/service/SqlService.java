package cn.luozc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.luozc.dao.ISqlDao;
import cn.luozc.model.Sql;
import cn.luozc.util.BeanToMapUtils;
import org.springframework.stereotype.Service;


@Service
public class SqlService {
	
	@Resource
	private ISqlDao sqlDao;

	/**
	 * 查询获取指定类型参数列表数据
	 * @param clazz	//数据类型
	 * @param sqlStr	//sql语句
	 * @param <T>		//
	 * @return	//
	 */
	public <T> T  selectEntity(Class<T> clazz,String sqlStr){
		List<Map<String, Object>> list = sqlDao.select(new Sql (sqlStr));
		if(list.size()>0) {
			return BeanToMapUtils.toBean(clazz, list.get(0));
		}
		return null;
	}

	/**
	 * 获取条数据有多个结果集只返回第一个
	 * @param clazz	//
	 * @param sqlStr	//
	 * @param <T>	//
	 * @return
	 */
	public <T> List<T>   selectList(Class<T> clazz,String sqlStr){
		List<Map<String, Object>> list = sqlDao.select(new Sql(sqlStr));
		List<T> result = new ArrayList<>();
		for(Map<String, Object> map:list) {
			result.add(BeanToMapUtils.toBean(clazz, map));
		}
		return result;
	}

	public List<Map<String, Object>> select(String sqlStr) {
		return sqlDao.select(new Sql(sqlStr));
	}

	public int insert(String sqlStr) {
		return sqlDao.insert(new Sql(sqlStr));
	}

	public int update(String sqlStr) {
		return sqlDao.update(new Sql(sqlStr));
	}

	public int delete(String sqlStr) {
		return sqlDao.delete(new Sql(sqlStr));
	}

	/**
	 * 添加map数据
	 * @param table	//表名
	 * @param map		//需要添加的数据
	 * @return	//返回影响的条数
	 */
	public int insertMap(String table,Map<String,String> map){
		String insert = "insert into "+table+" (";
		String valueStr = ")values(";
		Iterator<String> iterator = map.keySet ().iterator ();
		while (iterator.hasNext ()){
			String key = iterator.next ();
			String value = map.get (key);
			insert +=key+",";
			valueStr +="'"+value+"',";
		}
		insert = insert.substring (0,insert.length ()-1);
		valueStr = valueStr.substring (0,valueStr.length ()-1);
		insert +=valueStr+")";
		return insert (insert);
	}

	public int updateMap(String table,Map<String,String> map,Map<String,String> whereMap){
		String updateStr = "update "+table+" set ";
		String whereStr = " where ";

		Iterator<String> updateIte = map.keySet ().iterator ();
		while(updateIte.hasNext ()){
			String key = updateIte.next ();
			updateStr += key+"=\""+map.get (key)+"\",";
		}
		Iterator<String> whereIte = whereMap.keySet ().iterator ();
		while (whereIte.hasNext ()){
			String key = whereIte.next ();
			whereStr += key+"=\""+whereMap.get (key)+"\" and ";
		}
		updateStr = updateStr.substring (0,updateStr.length ()-1)+" "+whereStr.substring (0,whereStr.length ()-4);
		return update (updateStr);
	}
}  
