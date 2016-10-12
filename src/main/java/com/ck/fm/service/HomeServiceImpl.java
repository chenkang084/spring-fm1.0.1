package com.ck.fm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ck.fm.dao.HomeDao;


@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeDao homeDao;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(HomeServiceImpl.class);
	
	/**
	 * note:need add throw RuntimeException
	 */
	@Transactional
	@Override
	public int updateAgeNonException() throws Exception {
		try {
			Map<String,Integer> map = new HashMap<String,Integer>();
			
			map.put("age", 10);
			
			homeDao.updateAge(map);
			
			map.put("age", 30);
			
			homeDao.updateAge(map);
		} catch (Exception e) {
			
			LOGGER.error("debug ****", e);
			
			throw new RuntimeException();
		}
		
		return 0;
	}

	@Transactional
	@Override
	public int updateAgeException() throws Exception {
		try {
			Map<String,Integer> map = new HashMap<String,Integer>();
			
			map.put("age", 10);
			
			homeDao.updateAge(map);
			//exception
			System.out.println(2/0);
			
			map.put("age", 30);
			
			homeDao.updateAge(map);
			
		} catch (Exception e) {
			
			LOGGER.error("debug ****", e);
			
			throw new RuntimeException();
		}
		return 0;
	}


	public List<String> queryData() {
		return homeDao.queryData();
	}

}
