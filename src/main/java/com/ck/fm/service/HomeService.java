package com.ck.fm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public interface HomeService {

	public List<String> queryData();
	
	/**
	 * test spring transaction 
	 * @return
	 * @throws Exception
	 */
	public int updateAgeNonException() throws Exception;
	
	public int updateAgeException() throws Exception;
}
