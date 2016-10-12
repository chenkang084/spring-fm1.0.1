package com.ck.fm.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ck.fm.utils.db.SqlParseUtil;

@Repository
public class HomeDaoImpl extends BaseDao implements HomeDao {
	
	@Override
	@Transactional
	public List<String> queryData() {
		
		String sql = "update customer set age = :age where name = 'jack'";
		List<String> dateList = null;
		
		
		try {
			
//			List<Integer> query = msJdbcTemplate.query(sql, new RowMapper<Integer>(){
//				@Override
//				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
//					
//					return rs.getInt("count");
//				}
//			});
//			
//			SqlParseUtil.getQuery("test");
//			
//			System.out.println("==============================="+query);
			
			int result = 0;
			
			Map map = new HashMap();
			
			map.put("age", 10);
			
			result = this.msJdbcTemplate.update(sql, map);
			
			map.put("age", 30);
			int temp = 2/0;
			
			result = this.msJdbcTemplate.update(sql, map);
			
			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return dateList;
	}
	
	@Override
	public int updateAge(Map map){
		
		String sql = "update customer set age = :age where name = 'jack'";
		
		int result = 0;
		
		result = this.msJdbcTemplate.update(sql, map);
		
		return result;
		
	}

}
