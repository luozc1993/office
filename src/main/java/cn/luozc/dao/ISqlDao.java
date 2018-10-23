package cn.luozc.dao;

import java.util.List;
import java.util.Map;

import cn.luozc.model.Sql;

public interface ISqlDao {
	
	List<Map<String,Object>> select(Sql sql);

	int selectCount(Sql sql);
	
	int update(Sql sql);
	
	int insert(Sql sql);
	
	int delete(Sql sql);

}
