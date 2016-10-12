package com.ck.fm.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


public interface HomeDao {

	public List<String> queryData();
	
	public int updateAge(Map map);
}
