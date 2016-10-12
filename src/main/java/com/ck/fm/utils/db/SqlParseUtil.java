package com.ck.fm.utils.db;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlParseUtil {

	private final String SQL_FILE = "/query.properties";
	private static final Logger LOGGER = LoggerFactory.getLogger(SqlParseUtil.class);
	private static Properties properties;
	private static final SqlParseUtil sqlParseUtil = new SqlParseUtil();
	
	private static SqlParseUtil GetInstance(){
		return sqlParseUtil;
	}
	
	private SqlParseUtil() {
		LOGGER.debug("Load sql properties from file {}", SQL_FILE);
		InputStream in = SqlParseUtil.class.getResourceAsStream( SQL_FILE);   
		properties = new Properties();  
	    try {  
	    	properties.load(in);  
	    } catch (Exception e) {  
	    	LOGGER.error("Error when read sql properties: {}", e.getMessage());
	        e.printStackTrace();  
	    }  
	}
	
	public static String getQuery(String key){
		LOGGER.debug("Read property value for key {}", key);
		
		if(properties == null) {
			LOGGER.error("Properties is null!");
    		return null;
    	}
    	String value = properties.getProperty(key);
    	LOGGER.debug("property value for key {} is {}", key, value);
    	return value;
	}
	
}
