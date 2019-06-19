package cn.luozc.modules.common.dao;

import java.util.List;
import java.util.Map;

import cn.luozc.modules.common.model.Sql;

public interface ISqlDao {
	
	List<Map<String,Object>> select(Sql sql);

	int selectCount(Sql sql);
	
	int update(Sql sql);
	
	int insert(Sql sql);
	
	int delete(Sql sql);

}
