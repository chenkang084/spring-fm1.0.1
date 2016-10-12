package com.ck.fm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BaseDao {
	
	@Autowired
	@Qualifier("msJdbcTemplate")
	public NamedParameterJdbcTemplate msJdbcTemplate;
	
}
