package com.ck.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ck.fm.service.HomeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {  
    "file:src/main/webapp/WEB-INF/spring/root-context.xml"
})  
public class TestSpring{
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private HomeService homeService;

	@Test
	public void test() {
		
		Object bean = applicationContext.getBean("mysqlDataSource");
		
		System.out.println("========================="+bean);
		
		try {
//			homeService.updateAgeNonException();
			homeService.updateAgeException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
